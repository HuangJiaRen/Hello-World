package com.xdf.huangli.并行流水线;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 21:34
 */
public class Multiply implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();
    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.i = msg.i * msg.j;
                Div.bq.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
