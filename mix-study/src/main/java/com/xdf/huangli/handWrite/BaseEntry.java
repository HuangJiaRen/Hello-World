package com.xdf.huangli.handWrite;

/**
 * @author huangli
 * @version 1.0
 * @description
 * @date 2019-08-28 11:36
 */
public interface BaseEntry<K,V> {
    /**
     * 获取键
     * @return
     */
    K getKey();

    /**
     * 获取值
     * @return
     */
    V getValue();
}
