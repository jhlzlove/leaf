package com.leaf.simpletest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jhlz
 * @version x.x.x
 * @since 2024/4/16 16:04
 */
public class SimpleTest {
    /**
     * Test Example:
     */
    @Test
    public void SbTest() {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("第一个虚拟线程调度");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).get();

            executorService.submit(() -> {
                System.out.println("第er个虚拟线程调度");
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
