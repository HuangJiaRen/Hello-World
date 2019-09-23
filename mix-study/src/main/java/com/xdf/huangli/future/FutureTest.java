package com.xdf.huangli.future;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-09-21 21:56
 */
public class FutureTest {
    final static ExecutorService executor = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<Map<String, String>> future1 = null;
        Future<Integer> future2 = null;
        future1 = executor.submit(() -> rpcService.getRpcResult());
        future2 = executor.submit(() -> httpService.getHttpResult());

        try {
            Map<String, String> result1 = future1.get(300, TimeUnit.MILLISECONDS);
            Integer result2 = future2.get(300, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();

            if(future1 != null){
                future1.cancel(true);
            }

            if(future2 != null){
                future2.cancel(true);
            }

            throw new RuntimeException(e);
        }
    }

    static class RpcService{
        Map<String, String> getRpcResult() throws Exception{
            //调用远程方法（远程方法耗时约10ms, 可以使用Thread.sleep模拟）
            Thread.sleep(100);
            return null;
        }
    }

    static class HttpService{
        Integer getHttpResult() throws Exception{
            //调用远程方法（远程方法耗时约20ms, 可以使用Thread.sleep模拟）
            Thread.sleep(200);
            return null;
        }
    }
}
