package com.xdf.huangli.leetCode;

/**
 *
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2));
        l1.getNext().setNext(new ListNode(3));
        l1.getNext().setNext(new ListNode(5));

        ListNode l2 = new ListNode(2);
        l2.setNext(new ListNode(4));
        l2.getNext().setNext(new ListNode(6));

        ListNode listNode = mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
