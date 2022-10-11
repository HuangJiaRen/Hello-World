package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:33
 */
public class Student0 implements Cloneable {
    String name;// 常量对象。
    int age;
    Professor0 p;// 学生1和学生2的引用值都是一样的。

    Student0(String name, int age, Professor0 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    @Override
    public Object clone() {
        Student0 o = null;
        try {
            o = (Student0) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }

        return o;
    }
}