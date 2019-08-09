package com.xdf.huangli.producerConsumer;

/**
 * @uthor huangli
 * @description
 * @date 2019/8/7 22:59
 */
public final class PCData {
    private final int intData;
    public PCData(int d){
        intData = d;
    }

    public PCData(String a){
        intData = Integer.valueOf(a);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString(){
        return "data:" + intData;
    }
}
