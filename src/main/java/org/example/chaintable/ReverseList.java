package org.example.chaintable;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/10 19:49
 */
// 翻转链表
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        return method2(head);
    }

    // 头插法, 遍历旧链表, 构造一个等长的新链表
    public ListNode method1(ListNode head) {
        ListNode current = head;
        ListNode newCurrent = null;
        while (current != null) {
            ListNode node = new ListNode();
            node.val = current.val;
            node.next = newCurrent;
            newCurrent = node;
            current = current.next;
        }
        return newCurrent;
    }

    // 头插法, 依赖旧链表的元素构造新链表
    public ListNode method4(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // 迭代
    public ListNode method2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // 递归
    // https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/#%E4%B8%80%E3%80%81%E9%80%92%E5%BD%92%E5%8F%8D%E8%BD%AC%E6%95%B4%E4%B8%AA%E9%93%BE%E8%A1%A8
    public ListNode method3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode last = method3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
