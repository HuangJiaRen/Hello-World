package com.xdf.huangli.atomticInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @uthor huangli
 * @description
 * @date 2019/7/30 22:38
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int j = 0; j < 10; j++) {
            ts[j] = new Thread(new AddThread());
        }

        for (int j = 0; j < 10; j++) {
            ts[j].start();
        }

        for (int j = 0; j < 10; j++) {
            ts[j].join();
        }

        System.out.println(i);
    }
}
