package org.example.chaintable;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/05 17:15
 */
// 86
public class Partition {
    public class ListNode {
        int val;
        Partition.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, Partition.ListNode next) { this.val = val; this.next = next; }
    }

    // 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //
    //你应当 保留 两个分区中每个节点的初始相对位置。
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            if(p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {

    }
}
