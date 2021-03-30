package com.xdf.huangli.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了“锁”，
 * 再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。
 * </P>
 *
 * @author huangli
 * @since 2021-03-29 13:40
 */
public class LockTest {
    public static void main(String[] args) {
        final Business business = new Business();
        ExecutorService executor =  Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            executor.execute(
                 new Runnable(){
                     @Override
                     public void run(){
                         business.service();
                     }
                 }

          );
            }
        executor.shutdown();
    }

    public static class Business{
        private int count;
        Lock lock = new ReentrantLock();
        Semaphore sp = new Semaphore(1);
        public void service(){
            //lock.lock();
            try {
                //当前线程使用count变量的时候将其锁住，不允许其他线程访问
                sp.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
               count++;
                 try {
                     Thread.sleep(1000);
               } catch (InterruptedException e) {
                     e.printStackTrace();
                    }
                System.out.println(count);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }finally{
                 //lock.unlock();
                 sp.release();  //释放锁
            }
        }
    }
}
