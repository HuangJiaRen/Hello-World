package com.xdf.huangli.DelayedTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-31 13:31
 */
public class DelayedTaskTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //定义延迟队列
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<DelayedTask>();

        //定义三个延迟任务
        DelayedTask task1 = new DelayedTask(10);
        DelayedTask task2 = new DelayedTask(5);
        DelayedTask task3 = new DelayedTask(15);

        delayQueue.add(task1);
        delayQueue.add(task2);
        delayQueue.add(task3);

        System.out.println(sdf.format(new Date()) + " start");

        while (delayQueue.size() != 0) {

            //如果没到时间，该方法会返回
            DelayedTask task = delayQueue.poll();

            if (task != null) {
                Date now = new Date();
                System.out.println(sdf.format(now));
            }

            Thread.sleep(1000);
        }
    }
}
