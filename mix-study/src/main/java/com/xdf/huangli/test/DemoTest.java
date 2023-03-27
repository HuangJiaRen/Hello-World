package com.xdf.huangli.test;

import cn.hutool.core.bean.BeanUtil;
import reactor.core.support.UUIDUtils;

import java.util.UUID;

/**
 * @author huangli
 * @version 1.0
 * @description
 * equals它的作用也是判断两个对象是否相等，如果对象重写了equals()方法，
 * 比较两个对象的内容是否相等；如果没有重写，比较两个对象的地址是否相同，价于“==”。
 * 同样的，equals()定义在JDK的Object.java中，这就意味着Java中的任何类都包含有equals()函数
 * @date 2020-12-04 23:56
 */
public class DemoTest {
    public static void main(String[] args) {
//        Object obj = new Object();
//        System.out.println(obj.equals(obj));
//        System.out.println(obj.hashCode());
//        System.out.println(obj.hashCode());
//
//        Student student = new Student();
//        student.setName("张三");
//        student.setAge(10);
//        student.setSex("男");
//
//        CopyStudent copyStudent = new CopyStudent();
//        BeanUtil.copyProperties(student, copyStudent);
//
//        System.out.println(UUIDUtils.create());


            System.out.println("V2.2.0".compareTo("V2.1.0") != -1);

        System.out.println();
    }
}
