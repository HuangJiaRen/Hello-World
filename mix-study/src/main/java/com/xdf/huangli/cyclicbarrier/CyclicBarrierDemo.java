package com.xdf.huangli.cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 *应用场景： CyclicBarrier可以用于多线程计算数据，最后合并计算结果的应用场景。
 * 比如现在需要计算10个人12个月内的工资详细，可以将线程分为10个，
 * 分别计算每个人的工资，最后，再用barrierAction将这些线程的计算结果进行整合，得出最后结果。
 * </P>
 *
 * @author huangli
 * @since 2021-03-30 13:33
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException{

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("汇总已分别计算出的两个员工的工资");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("计算出员工1的工资");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("计算出员工2的工资");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "thread2");


        thread1.start();
        thread2.start();

        System.out.println("====end====");
    }

}



