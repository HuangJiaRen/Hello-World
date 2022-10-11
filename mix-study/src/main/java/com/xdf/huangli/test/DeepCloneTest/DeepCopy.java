package com.xdf.huangli.test.DeepCloneTest;

/**
 * <p>
 * 深拷贝和浅拷贝的区别：https://www.cnblogs.com/qianxiaoruofeng/p/15542512.html
 * </P>
 *
 * @author huangli
 * @since 2022-10-11 15:44
 */
public class DeepCopy {
    public static void main(String args[]) {
        long t1 = System.currentTimeMillis();
        Professor p = new Professor("wangwu", 50);
        Student s1 = new Student("zhangsan", 18, p);
        Student s2 = (Student) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);// 学生1的教授不改变。
        System.out.println("name=" + s2.p.name + "," + "age=" + s2.p.age);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
