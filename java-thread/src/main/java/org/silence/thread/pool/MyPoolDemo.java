package org.silence.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池demo类
 * Java中提供了四种线程池：
 * FixedThreadPool——固定大小线程池，线程数量一定
 * CachedThreadPool——缓存线程池，线程数量由提交的任务数量决定
 * SingleThreadExecutor——单线程线程池，只有一个线程
 * ScheduledThreadPool——调度线程池，池中的线程会定时执行
 */
public class MyPoolDemo {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(9);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(9);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        };

        for (int i = 0; i < 14; i++) {
//            fixedThreadPool.submit(runnable);
//            cachedThreadPool.submit(runnable);
//            singleThreadPool.submit(runnable);
            scheduledThreadPool.submit(runnable);
        }

//        fixedThreadPool.shutdown();
//        cachedThreadPool.shutdown();
//        singleThreadPool.shutdown();
        scheduledThreadPool.shutdown();
    }
}
