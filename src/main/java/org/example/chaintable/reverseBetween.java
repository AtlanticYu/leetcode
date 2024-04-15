package org.example.chaintable;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/10 20:23
 */
// 92 反转链表的一部分
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        for(int i = 0 ; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode prev = p0;
        ListNode curr = p0.next;
        for(int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        p0.next.next = curr;
        p0.next = prev;
        return dummy.next;
    }
}
