package com.xdf.huangli.disruptor;

import reactor.jarjar.com.lmax.disruptor.WorkHandler;

/**
 * @author huangli
 * @version 1.0
 * @description 消费者读取数据进行处理
 * @date 2019-08-09 23:00
 */
public class Consumer implements WorkHandler<PCData> {

    /**
     * 框架回调方法
     * @param event
     * @throws Exception
     */
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId() + ":Event: --"
        + event.get() + "--");
    }
}
