package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:42
 */
public class Student implements Cloneable {
    String name;
    int age;
    Professor p;

    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    @Override
    public Object clone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        assert o != null;
        o.p = (Professor) p.clone();
        return o;
    }
}