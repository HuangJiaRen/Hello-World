package com.xdf.huangli.threeSingleton;

/**
 * <p>
 *  饿汉式单例模式
 *
 *  饿汉式类加载时就初始化，浪费内存，不能延时加载；没有加锁效率高，饿汉式通过类加载机制初始化，每个类只加载一次，天生线程安全的。
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 11:18
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    static {
        singleton2 = new Singleton2();
    }

    private Singleton2() {}

    public Singleton2 getInstance() {
        return singleton2;
    }
}
