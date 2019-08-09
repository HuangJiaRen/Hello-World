package com.xdf.huangli.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @uthor huangli
 * @description
 * @date 2019/8/7 22:57
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;//内存缓冲区
    private static AtomicInteger count = new AtomicInteger();//总数，原子操作
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();

        System.out.println("start producer id=" + Thread.currentThread().getId());
        while (isRunning){
            try {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());//构造任务数据
                System.out.println(data + " is put into queue");
                if(!queue.offer(data, 2, TimeUnit.SECONDS)){//提交数据到缓冲区中
                    System.out.println("failed to put data: " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop(){
        isRunning = false;
    }
}
