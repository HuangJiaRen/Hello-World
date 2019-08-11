package com.xdf.huangli.future;

//import javax.xml.crypto.Data;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 09:49
 */
public class Client {
    public Data request(final String queryStr){
        final FutureData futureData = new FutureData();
        new Thread(){
            @Override
            public void run(){
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();

        return futureData;
    }
}
