package com.leaf.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * ThreadPoolConfig: 连接池配置
 * 不说别的，只要是 Java 项目，必须要有，哪怕不用，也要把参数什么的配上！就这么任性
 * <p>
 * 《Java并发编程实战》（http://mng.bz/979c）一书中，Brian Goetz和合著者们为线程池大小的优化提供了不少中肯的建议。
 * 这非常重要，如果线程池中线程的数量过多，最终它们会竞争稀缺的处理器和内存资源，浪费大量的时间在上下文切换上。
 * 反之，如果线程的数目过少，正如你的应用所面临的情况，处理器的一些核可能就无法充分利用。
 * Brian Goetz建议，线程池大小与处理器的利用率之比可以使用下面的公式进行估算：
 * N_threads = N_CPU * U_CPU * (1 + W/C)
 * 其中：
 * N_CPU 是处理器的核的数目，可以通过 Runtime.getRuntime().availableProcessors() 得到
 * U_CPU 是期望的CPU利用率（该值应该介于 0 和 1 之间）
 * W/C 是等待时间与计算时间的比率
 *
 * @author jhlz
 * @since 2022/9/16 12:34:00
 */
public class ThreadPoolConfig {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolConfig.class);
    // 核心线程池大小
    private final int corePoolSize = 50;

    /**
     * 为线程池起个名称，参数配上！
     *
     * @return
     */
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 最大可创建的线程数
        int maxPoolSize = 200;
        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        // 队列最大长度
        int queueCapacity = 1000;
        executor.setQueueCapacity(queueCapacity);
        // 线程池维护线程所允许的空闲时间
        int keepAliveSeconds = 300;
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    /**
     * 执行周期性或定时任务
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(corePoolSize,
                // new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
                (r) -> {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    thread.setName("schedule-pool-%d");
                    return thread;
                },
                new ThreadPoolExecutor.CallerRunsPolicy()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                printException(r, t);
            }
        };
    }

    /**
     * 打印线程异常信息
     */
    public static void printException(Runnable r, Throwable t) {
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            log.error(t.getMessage(), t);
        }
    }
}
