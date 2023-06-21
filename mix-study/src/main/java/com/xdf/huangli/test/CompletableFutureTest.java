package com.xdf.huangli.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-08-23 11:23
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        System.out.println("start->" + System.currentTimeMillis());
        List test = asyncTest();
        System.out.println(JSON.toJSONString(test));
        System.out.println("end->" + System.currentTimeMillis());
    }

    public static List  asyncTest(){
        List<String> asList = Arrays.asList("1", "2");
        CompletableFuture<List> completableFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(10000);
                        asList.add("3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            System.out.println("res ->" + JSON.toJSONString(asList));
                    return null;
                }
        );

//        try {
//            List list = completableFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        return asList;
    }
}
