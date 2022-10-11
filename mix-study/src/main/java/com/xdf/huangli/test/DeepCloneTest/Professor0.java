package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:32
 */
public class Professor0 implements Cloneable {
    String name;
    int age;

    Professor0(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}