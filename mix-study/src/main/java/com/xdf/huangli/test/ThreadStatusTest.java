package com.xdf.huangli.test;


import java.lang.management.ManagementFactory;

/**
 * @author huangli
 * @version 1.0
 * @description RUNNABLE 线程运行中或I/O等待
 * BLOCKED 线程在等待monitor锁(synchronized关键字)
 * TIMED_WAITING 线程在等待唤醒，但设置了时限
 * WAITING 线程在无限等待唤醒
 * @date 2020-09-02 18:21
 */
public class ThreadStatusTest {
    public static void main(String[] args) {
        System.out.println(ThreadStatusTest.pid());
//        runnable();     // 1
//             blocked();      // 2
//             waiting();      // 3
             timedWaiting(); // 4

    }

    public static String pid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.split("@")[0];
    }

    public static void runnable() {
        long i = 0;
        while (true) {
            i++;
        }
    }

    public static void blocked() {
        final Object lock = new Object();
        new Thread() {
            public void run() {
                synchronized (lock) {
                    System.out.println("i got lock, but don't release");
                    try {
                        Thread.sleep(1000L * 1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        synchronized (lock) {
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void waiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void timedWaiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(10 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
