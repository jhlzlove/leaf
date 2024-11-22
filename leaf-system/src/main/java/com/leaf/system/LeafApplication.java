package com.leaf.system;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import org.babyfish.jimmer.sql.JSqlClient;

@QuarkusMain
public class LeafApplication {

    /**
     * 这里不要放入任何启动逻辑，它的用处就是可以从 IDE 中直接启动
     * @param args  参数
     */
    public static void main(String[] args){
        Quarkus.run(App.class, args);
        System.out.println("启动成功！");
    }

    /**
     * 启动时自定义的任务在此处编写
     */
    public static class App implements QuarkusApplication {
        @Inject
        JSqlClient sqlClient;

        @Override
        public int run(String... args) throws Exception {
            System.out.println(sqlClient);
            return 0;
        }
    }
}