package com.xdf.huangli.future;

//import javax.xml.crypto.Data;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 09:40
 */
public class RealData implements Data {
    protected final String result;
    public RealData(String para){
        //RealData的构造可能很慢，需要用户等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                //使用sleep，代替一个很慢的操作过程
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        result = sb.toString();
    }

    public String getResult(){
        return result;
    }
}
