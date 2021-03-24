package com.xdf.huangli.leetCode.node;

/**
 * @author huangli
 * @version 1.0
 * @description Java实现单链表反转操作
 * 先说下思路：
 * 所谓的单链表反转，就是把每个节点的指针域由原来的指向下一个节点变为指向其前一个节点。但由于单链表没有指向前一个节点的指针域，
 * 因此我们需要增加一个指向前一个节点的指针pre，用于存储每一个节点的前一个节点。此外，还需要定义一个保存当前节点的指针cur，以及下一个节点的next。
 * 定义好这三个指针后，遍历单链表，将当前节点的指针域指向前一个节点，之后将定义三个指针往后移动，直至遍历到最后一个节点停止。
 * ————————————————
 * 版权声明：本文为CSDN博主「WeekenLin」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/lwkrsa/article/details/82015364
 * @date 2021-03-17 23:14
 */
public class MainTest {
    public static void main(String[] args) {
        Node node0 = new Node("10");
        Node node1 = new Node("11");
        Node node2 = new Node("12");
        Node node3 = new Node("13");
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node reverseListNode = reverseListNode(node0);
    }

    public static Node reverseListNode(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null){
            //nextNode 指向下一个节点
            nextNode = curNode.getNext();

            //将当前节点next域指向前一个节点
            curNode.setNext(preNode);

            //preNode 指针向后移动
            preNode = curNode;

            //curNode指针向后移动
            curNode = nextNode;
        }

        return preNode;
    }
}
