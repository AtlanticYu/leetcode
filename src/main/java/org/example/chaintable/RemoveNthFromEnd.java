package org.example.chaintable;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/19 15:45
 */
// 19 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for(int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        ListNode p2Before = new ListNode(-1);
        for(;p1 != null;) {
            p1 = p1.next;
            p2Before = p2;
            p2 = p2.next;
        }
        if (p2Before.next == null) {
            return head.next;
        } else {
            p2Before.next = p2.next;
            return head;
        }
    }
}
