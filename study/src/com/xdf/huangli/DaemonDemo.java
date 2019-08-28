package com.xdf.huangli;

/**
 * 守护线程
 * @author huangli
 */
public class DaemonDemo {
    public static class DameonT extends Thread{
        @Override
        public void run(){
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DameonT();
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
