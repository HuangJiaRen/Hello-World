package com.xdf.huangli.handWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangli
 * @version 1.0
 * @description 手写hashMap
 * @date 2019-08-28 10:54
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    //阈值
    private static final float LOAD_FACTOR = 0.75f;

    //数组默认初始值长度
    private static final int DEFAULT_INIT_CAPACITY = 16;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //数组容器存放元素，但不初始化，使用懒加载方式
    private MyEntry<K, V>[] table = null;
    
    private static int size;

    @Override
    public V put(K k, V v) {
        if(table == null){
            table = new MyEntry[DEFAULT_INIT_CAPACITY];
        }
        
        if(size > DEFAULT_INIT_CAPACITY * LOAD_FACTOR){
            resize();
        }
        return null;
    }

    /**
     * 对size进行扩容
     */
    private void resize() {
        //1.创建新的table长度扩展为以前的两倍
        int newLength = DEFAULT_INIT_CAPACITY * 2;
        MyEntry<K,V>[] newtable = new MyEntry[newLength];
        List<MyEntry<K,V>> list = new ArrayList<>();

        //2.将以前的table中的元素取出，并重新计算index存入
        for (int i = 0; i < table.length; i++) {
            MyEntry<K,V> oldTable = table[i];
            while (oldTable != null){
                //将table[i]的位置赋值为空
                table[i] = null;

                //计算新的index值
                K key = oldTable.getKey();
                int index = getIndex(key, newLength);

            }
        }
    }

    /**
     * 获取index
     * @param key
     * @param newLength
     * @return
     */
    private int getIndex(K key, int newLength) {
        int hashCode = key.hashCode();
        int index = hashCode % newLength;
        return index;
    }

    @Override
    public V get(Object o) {
        return null;
    }
}
