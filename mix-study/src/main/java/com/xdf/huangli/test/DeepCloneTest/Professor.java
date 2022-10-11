package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:42
 */
public class Professor implements Cloneable {
    String name;
    int age;

    Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}