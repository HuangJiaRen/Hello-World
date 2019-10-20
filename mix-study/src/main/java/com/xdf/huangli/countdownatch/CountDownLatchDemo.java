package com.xdf.huangli.countdownatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @uthor huangli
 * @description
 * CountDownLatch(int count) //实例化一个倒计数器，count指定计数个数
 * countDown() // 计数减一
 * await() //等待，当计数减到0时，所有线程并行执行
 * @date 2019/7/29 22:13
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch latch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            exec.submit(demo);
        }

        // 等待检查
        latch.await();

        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        exec.shutdown();
    }
}
