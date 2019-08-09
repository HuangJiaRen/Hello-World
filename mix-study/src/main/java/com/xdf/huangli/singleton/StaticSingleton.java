package com.xdf.huangli.singleton;

/**
 * @uthor huangli
 * @description 单例模式
 * @date 2019/8/6 22:32
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticSingleton.getInstance();
    }
}
