package com.xdf.huangli.并行流水线;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-11 21:36
 */
public class Div implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();
    @Override
    public void run() {
        while (true){
            Msg msg = null;
            try {
                msg = bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg.i = msg.i / 2;
            System.out.println(msg.orgStr + " = " + msg.i);
        }
    }
}
