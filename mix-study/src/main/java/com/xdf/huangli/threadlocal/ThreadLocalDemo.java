package com.xdf.huangli.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-07-28 22:46
 */
public class ThreadLocalDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    public static class ParseDate implements Runnable{
        int i = 0;

        public ParseDate(int i){
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if(tl.get() == null){
                    tl.set(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));
                }

//                Date t = sdf.parse("2016-03-29 19:29:" + i%60);
                Date t = tl.get().parse("2016-03-29 19:29:" + i%60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
