package com.xdf.huangli.synchronized1;

/**
 * @uthor huangli
 * @description i的值会存在小于2000000的情况
 * @date 2019/7/16 22:46
 */
public class AccountingVo1 implements Runnable {
    static AccountingVo1 instance = new AccountingVo1();
    public static volatile int i = 0;
    @Override
    public void run() {
        for (int j=0; j<1000000; j++){
            increase();
        }
    }

    private static void increase() {
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
