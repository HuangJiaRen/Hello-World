package com.xdf.huangli.future;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 09:39
 */
public class FutureData implements Data {
    //FutureDta是RealData的包装
    protected RealData realData = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }

        this.realData = realData;
        isReady = true;
        //RealData已经被注入，通知getResult()方法
        notifyAll();
    }

    //等待RealData构造完成
    @Override
    public synchronized String getResult(){
        while (!isReady){
            try {
                //一直等待，直到RealData被注入
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //由RealData实现
        return realData.result;
    }
}
