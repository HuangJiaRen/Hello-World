package com.xdf.huangli.threadFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @uthor huangli
 * @description
 * @date 2019/7/23 23:05
 */
public class ThreadFactoryTest {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:"
                    + Thread.currentThread().getId());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    System.out.println("creat " + t);
                    return t;
                });

        for (int i = 0; i < 5; i++) {
            es.submit(myTask);
        }
        Thread.sleep(2000);
    }
}
