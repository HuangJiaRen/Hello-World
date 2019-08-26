package com.xdf.huangli.jdk8;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-14 10:16
 */
public class TestBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == i){
                    System.out.println(j);
                }

            }
        }
    }
}
