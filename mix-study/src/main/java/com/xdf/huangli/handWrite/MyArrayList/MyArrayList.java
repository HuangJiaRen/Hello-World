package com.xdf.huangli.handWrite.MyArrayList;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 一、ArrayList的底层是Object类的数组，默认长度是10,超过10后，长度变为原长度的2倍+1。
 *
 * 二、可以简单的认为是一个动态数组；实际上ArrayList就是用数组实现的，长度不够时，调用Arrays.copyOf方法，拷贝当前数组到一个新的长度更大的数组。
 *
 * 三、特点：随机访问速度快，插入和移除性能较差(数组的特点)；
 *
 *     支持null元素；
 *
 *     有顺序；
 *
 *     元素可以重复；
 *
 *     线程不安全。
 *     参考：http://blog.csdn.net/smile_juan/article/details/7272841
 *
 * @date 2019-09-16 09:26
 */
public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;

    private int size;

    /**
     * 构造函数，初始化数组
     */
    private MyArrayList(){
        clear();
    }

    public void clear(){
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public boolean add(T t){
        add(size(), t);
        return true;
    }

    public void add(int index, T t) {
        if(items.length == size()){
            ensureCapacity(2 * size() + 1);
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i -1];
        }

        items[index] = t;

        size ++;
    }

    public int size() {
        return size;
    }

    public void ensureCapacity(int newSize) {
        if(newSize < size()){
            return;
        }

        T[] oldItems = items;

        items = (T[]) new Object[newSize];

        for(int i = 0; i < size(); i++){
            items[i] = oldItems[i];
        }
    }

    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return items[index];
    }

    public boolean remove(Object obj){
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)){
                remove(i);
            }

            break;
        }

        return true;
    }

    public Object remove(int index){
        if(index < 0 || index > size()){
            return null;
        }

        int arrnums = size() - index - 1;
        Object oldValue = items[index];
        if(arrnums > 0){
            System.arraycopy(items, index+1, items, index, arrnums);
        }
        items[--size] = null;
        return oldValue;
    }

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
