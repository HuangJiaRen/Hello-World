package com.xdf.huangli.volatile1;

/**
 * @uthor huangli
 * @description
 * @date 2019/7/7 9:58
 */
public class NoVisibility {
    private volatile static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){}
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }
}
