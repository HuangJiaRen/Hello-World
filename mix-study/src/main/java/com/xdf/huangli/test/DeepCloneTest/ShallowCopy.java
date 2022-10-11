package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:33
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Professor0 p = new Professor0("wangwu", 50);
        Student0 s1 = new Student0("zhangsan", 18, p);
        Student0 s2 = (Student0) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        s2.name = "z";
        s2.age = 45;
        // 学生1的教授
        System.out.println("学生s1的姓名：" + s1.name + "\n学生s2的姓名：" + s2.name + "\n学生s1教授的姓名：" + s1.p.name + "," + "\n学生s1教授的年纪:" + s1.p.age);
    }
}
