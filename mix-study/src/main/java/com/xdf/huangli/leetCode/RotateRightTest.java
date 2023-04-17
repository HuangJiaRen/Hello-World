package com.xdf.huangli.leetCode;

/**
 * <p>
 * 61. 旋转链表

 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * </P>
 *
 * @author huangli
 * @since 4/17/23 9:06 AM
 */
public class RotateRightTest {
    public ListNode rotateRight(ListNode head, int k){
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null){
            iter = iter.next;
            n ++;
        }
        int add = n - k % n;
        if(add == n){
            return head;
        }
        iter.next = head;
        while (add-- > 0){
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
