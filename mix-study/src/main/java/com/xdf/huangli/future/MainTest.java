package com.xdf.huangli.future;


/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 09:53
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = (Data) client.request("name");
        System.out.println("请求完毕");
        Thread.sleep(2000);
        System.out.println("数据 = " + data.getResult());
    }
}
