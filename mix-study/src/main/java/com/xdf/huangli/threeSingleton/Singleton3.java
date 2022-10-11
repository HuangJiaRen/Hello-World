package com.xdf.huangli.threeSingleton;

/**
 * <p>
 * 懒汉式
 * 懒汉式能做到延迟加载，但是线程不安全。可以通过在方法上加同步锁synchronized或者在代码块上加，实现线程安全，但是效率低下。
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 11:41
 */
public class Singleton3 {
    private static Singleton3 instance;

    private  Singleton3 () {}

    public static Singleton3 getInstance() {
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
