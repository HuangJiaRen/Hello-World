package com.xdf.huangli.disruptor.cpuCache;

/**
 * @author huangli
 * @version 1.0
 * @description CPU cache的优化，解决伪共享问题
 * @date 2019-08-10 22:56
 */
public class FalseSharing implements Runnable {
    public final static int NUM_THREADS = 8;//change
    public final static long ITEMRATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public FalseSharing(final int arrayIndex){
        this.arrayIndex = arrayIndex;
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + (System.currentTimeMillis() - start));
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread t: threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }


    @Override
    public void run() {
        long i = ITEMRATIONS + 1;
        while (0 != --i){
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong{
        public volatile long value = 0L;
//        public long p1, p2, p3, p4, p5, p6, p7;//comment out
    }
}
