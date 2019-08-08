package com.xdf.huangli.classLoadSequence;

import java.util.ArrayList;

/**
 * @author huangli
 * @version 1.0
 * @description
 * @date 2019-08-02 15:58
 *
 * 类加载顺序：
 *  1.首先加载父类的静态代码块
 *  2.在加载子类的静态代码块
 *  3.加载父类的初始化代码块
 *  4.加载父类的构造方法
 *  5.加载子类的初始化代码块
 *  6.加载子类的构造方法
 *  7.调用子类的方法
 */

public class A extends B {
    static int i = 0;
    static {
        System.out.println("ClassA --> static block B1 + " + i);
    }

    int j = 0;

    static {
        i++;
        System.out.println("ClassA -->static block2 +" + i);
    }

    public A(){
        i++;
        j++;
        System.out.println("ClassA  contruct i:" + i + ";j:" + j);
    }

    {
        System.out.println("ClassA common block + " + i);
    }

    @Override
    public void getValue() {
        i++;
        System.out.println("ClassA getvalueA:" + i);
    }

    public static void getValues() {
        i++;
        System.out.println("ClassA static getvaluesA:" + i);
    }


//    public static int value1;
//    public static int value2 = 0;
//    private static A singleton2 = new A();
//
//
//    private A(){
//        value1++;
//        value2++;
//    }
//
//    public static A getInstance2(){
//        return singleton2;
//    }


    public static void main(String[] args) {
        A.getValues();
        A.i = 2;
        A a = new A();
        a.getValue();
//        A instance = A.getInstance2();
//        System.out.println("Instance 1 = " + instance.value1);
//        System.out.println("Instance 2 = " + instance.value2);

        ArrayList<String> arrayList = new ArrayList<>();

        System.out.println("ssss");
    }
}
