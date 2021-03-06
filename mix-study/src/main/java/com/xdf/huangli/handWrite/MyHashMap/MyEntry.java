package com.xdf.huangli.handWrite.MyHashMap;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-28 14:47
 */
public class MyEntry<K, V> implements BaseEntry <K, V>{
    private K k;
    private V v;
    MyEntry<K, V> next;

    public MyEntry(K k, V v, MyEntry<K, V> next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public void setValue(V v) {
        this.v = v;
    }

    public MyEntry<K, V> getNext() {
        return next;
    }

    public void setNext(MyEntry<K, V> next) {
        this.next = next;
    }

}
