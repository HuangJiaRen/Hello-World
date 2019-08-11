package com.xdf.huangli.并行流水线;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 21:30
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
    @Override
    public void run() {
        while (true){
            Msg msg = null;
            try {
                msg = bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg.j = msg.i + msg.j;
            Multiply.bq.add(msg);
        }
    }
}
