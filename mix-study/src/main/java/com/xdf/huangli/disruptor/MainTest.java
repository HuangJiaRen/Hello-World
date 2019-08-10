package com.xdf.huangli.disruptor;

import reactor.jarjar.com.lmax.disruptor.BlockingWaitStrategy;
import reactor.jarjar.com.lmax.disruptor.RingBuffer;
import reactor.jarjar.com.lmax.disruptor.dsl.Disruptor;
import reactor.jarjar.com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-09 23:13
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new BlockingWaitStrategy());

        disruptor.handleEventsWithWorkerPool(new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (int i = 0; true; i++) {
            buffer.putLong(0,1);
            producer.pushData(buffer);
            Thread.sleep(1000);
            System.out.println("add dta " + i);
        }
    }
}
