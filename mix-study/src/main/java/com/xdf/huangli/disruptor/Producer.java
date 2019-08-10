package com.xdf.huangli.disruptor;

import reactor.jarjar.com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-09 23:04
 */
public class Producer {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer byteBuffer){
        //得到下一个可用的序列号
     long sequence = ringBuffer.next();

     //通过序列号取得下一个空闲可用的PCData对象
     PCData event = ringBuffer.get(sequence);

     //将PCData对象的数据设为期望值
     event.set(byteBuffer.getLong(0));

     //发布数据，发布后的数据才会被消费者看见
     ringBuffer.publish(sequence);
    }
}
