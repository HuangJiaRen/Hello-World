package com.xdf.huangli.threeSingleton;

/**
 * <p>
 * 双检索单例模式
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 11:10
 */
public class Singleton1 {
    private static volatile Singleton1 singleton1;

    private Singleton1() {}

    public static Singleton1 getInstance(){
        if (singleton1 == null) { //第一次判断
            synchronized (Singleton1.class) { //加锁
                if (singleton1 == null) { // 第二次判断
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
