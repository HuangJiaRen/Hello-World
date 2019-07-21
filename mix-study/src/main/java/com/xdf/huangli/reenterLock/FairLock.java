package com.xdf.huangli.reenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 * @version 1.0
 * @description 公平锁
 * @date 2019-07-21 09:31
 */
public class FairLock implements Runnable {
public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "Thread_1");
        Thread t2 = new Thread(fairLock, "Thread_2");
        t1.start();
        t2.start();
    }
}
