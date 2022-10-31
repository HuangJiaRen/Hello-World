package com.xdf.huangli.ScheduledExecutorService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-31 13:46
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(100);
        for (int i = 10; i > 0; i--) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(
                            "Work start, thread id:" + Thread.currentThread().getId() + " " + sdf.format(new Date()));
                }

            }, i, TimeUnit.SECONDS);
        }
    }
}
