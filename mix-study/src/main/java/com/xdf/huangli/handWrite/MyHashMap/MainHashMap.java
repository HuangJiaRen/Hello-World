package com.xdf.huangli.handWrite.MyHashMap;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-31 16:53
 */
public class MainHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i, i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
    }
}
