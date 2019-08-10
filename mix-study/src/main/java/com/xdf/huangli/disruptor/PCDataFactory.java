package com.xdf.huangli.disruptor;

import reactor.jarjar.com.lmax.disruptor.EventFactory;

/**
 * @author huangli
 * @version 1.0
 * @description 产生PCData对象的工厂
 * @date 2019-08-09 23:03
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
