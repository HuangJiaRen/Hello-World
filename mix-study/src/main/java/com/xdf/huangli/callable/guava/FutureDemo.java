package com.xdf.huangli.callable.guava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.xdf.huangli.callable.RealData;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author huangli
 * @version 1.0
 * @description Guava对Future模式的支持  非阻塞
 * @date 2019-08-11 18:37
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(
                Executors.newFixedThreadPool(10));
        ListenableFuture<String> task = service.submit(new RealData("x"));

        task.addListener(() -> {
            System.out.println("异步处理成功：");
            try {
                System.out.println(task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        System.out.println("main task done......");
        Thread.sleep(3000);
    }
}
