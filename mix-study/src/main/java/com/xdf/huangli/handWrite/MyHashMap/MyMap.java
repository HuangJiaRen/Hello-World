package com.xdf.huangli.handWrite.MyHashMap;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-28 11:29
 */
public interface MyMap<K, V> {
    /**
     * 存
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * 取
     * @param k
     * @return
     */
    V get(K k);
}
