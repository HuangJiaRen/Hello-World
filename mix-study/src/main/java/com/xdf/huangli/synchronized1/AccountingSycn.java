package com.xdf.huangli.synchronized1;

/**
 * @uthor huangli
 * @description:synchronized确保了线程同步，确保了线程安全同时也保证了线程的有序性和可见性
 * @date 2019/7/16 22:46
 */
public class AccountingSycn implements Runnable {
    static AccountingSycn instance = new AccountingSycn();
    public static int i = 0;
    @Override
    public void run() {
        for (int j=0; j<1000000; j++){
            increase();
        }
    }

    private synchronized void increase() {
        i ++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
