package com.xdf.huangli.leetCode.node;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2021-03-17 23:12
 */
public class Node {

    private Object data;//数据域
    private Node next;//指针域

    public Node(Object data){
        this.data = data;
    }

    public Node(Object data,Node next){
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}