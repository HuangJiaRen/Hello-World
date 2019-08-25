package com.xdf.huangli;

/**
 * 线程优先级
 * @author huangli
 */
public class PriorityDemo {
    public static class HightPriority extends Thread{
        static int count = 0;
        @Override
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count ++;
                    if(count > 1000000){
                        System.out.println("HightPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static int count = 0;
        @Override
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count ++;
                    if(count > 1000000){
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread hight = new HightPriority();
        LowPriority low = new LowPriority();

        hight.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.NORM_PRIORITY);

        hight.start();
        low.start();
    }
}
