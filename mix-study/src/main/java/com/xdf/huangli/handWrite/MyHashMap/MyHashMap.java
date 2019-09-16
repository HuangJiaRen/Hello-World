package com.xdf.huangli.handWrite.MyHashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangli
 * @version 1.0
 * @description 手写hashMap
 * @date 2019-08-28 10:54
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    //HashMap默认负载因子，负载因子越小，hash冲突机率越低，综合结论得出0.75最为合适
    private static final float LOAD_FACTOR = 0.75f;

    //数组默认初始值长度
    private static int DEFAULT_INIT_CAPACITY = 1 << 4;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //数组容器存放元素，但不初始化，使用懒加载方式
    private MyEntry<K, V>[] table = null;

    //记录当前容器实际大小
    private static int size;

    @Override
    public V put(K k, V v) {
        //1.判断容器是否为空为空则初始化
        if(table == null){
            table = new MyEntry[DEFAULT_INIT_CAPACITY];
        }

        //如果size大于阈值则进行扩容
        if(size > DEFAULT_INIT_CAPACITY * LOAD_FACTOR){
            resize();
        }

        //2.计算出新的index角标
        int index = getIndex(k, DEFAULT_INIT_CAPACITY);

        //将k-v键值对放进相对应的角标，如果计算出角标相同则以链表的形势存放
        MyEntry<K, V> entry = table[index];
        if(entry == null){
            table[index] = new MyEntry<>(k, v,  null);
            size ++;
            return table[index].getValue();
        }else {
            MyEntry<K, V> newTable = entry;
            while (newTable != null){
                if(k.equals(newTable.getKey()) || k == newTable.getKey()){
                    newTable.setValue(v);
                    size ++;
                    return v;
                }
                newTable = entry.getNext();
            }
            table[index] = new MyEntry<K,V>(k,v,table[index]);
            size ++;

            return table[index].getValue();
        }
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

                //将以前的Entry保存下来
                MyEntry<K, V> nextEntry = oldTable.next;

                //将newtable的值赋值在oldtable的nextnode上，如果以前是空，则nextnode是空
                oldTable.setNext(newtable[i]);
                newtable[i] = oldTable;

                //将以前的nextcode赋值给oldtable以便继续遍历
                oldTable = nextEntry;
            }
        }

        //将新的table赋值回老的table
        table = newtable;
        DEFAULT_INIT_CAPACITY = newLength;
        newtable = null;
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
    public V get(K k) {
        int index = getIndex(k, DEFAULT_INIT_CAPACITY);
        MyEntry<K, V> entry = table[index];
        if(k.equals(entry.getKey()) || k == entry.getKey()){
            return entry.getValue();
        }else {
            MyEntry<K, V> next = entry.getNext();
            while (next != null){
                if(k.equals(next.getKey()) || k == next.getKey()){
                    return next.getValue();
                }
            }
        }

        return null;

    }
}
