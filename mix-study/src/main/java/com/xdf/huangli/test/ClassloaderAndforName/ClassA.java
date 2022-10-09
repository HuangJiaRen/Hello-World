package com.xdf.huangli.test.ClassloaderAndforName;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-09-22 17:59
 */
public class ClassA {
    static {
        System.out.println("ClassA静态代码块执行");
    }

    static ClassA cla = new ClassA();

    {
        System.out.println("ClassA代码块");
    }
}


