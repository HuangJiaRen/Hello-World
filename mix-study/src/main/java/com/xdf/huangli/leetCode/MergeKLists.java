package com.xdf.huangli.leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangli
 * @version 1.0
 * @description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-08-05 16:33
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.setNext(new ListNode(2));
        node1.next.setNext(new ListNode(3));

        ListNode node2 = new ListNode(1);
        node2.setNext(new ListNode(5));
        node2.next.setNext(new ListNode(4));

        ListNode node3 = new ListNode(4);
        node3.setNext(new ListNode(5));
        node3.next.setNext(new ListNode(6));

        ListNode[] listNodes = {node1, node2, node3};
        ListNode listNode = mergeKLists(listNodes);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }

        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for(int i=0;i<lists.length;i++) {
            while(lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while( !queue.isEmpty() ) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

}
