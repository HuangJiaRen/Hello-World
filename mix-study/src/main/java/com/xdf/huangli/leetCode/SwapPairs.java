package com.xdf.huangli.leetCode;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @date 2020-08-05 18:01
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.setNext(new ListNode(12));
        listNode.next.setNext(new ListNode(4));

        ListNode node = swapPairs(listNode);
    }

    public static ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }


}
