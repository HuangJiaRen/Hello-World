package com.xdf.huangli.callable;


import java.util.concurrent.Callable;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 10:15
 */
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para){
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            Thread.sleep(100);
        }
        return sb.toString();
    }
}
