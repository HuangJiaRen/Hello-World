package com.xdf.huangli.reenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangli
 * @version 1.0
 * @description ReentrantLock重入锁
 * @date 2019-07-20 23:17
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++){
            lock.lock();
            try {
                i++;
            }finally {
               lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock rl = new ReenterLock();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
