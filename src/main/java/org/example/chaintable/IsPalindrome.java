package org.example.chaintable;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/18 18:47
 */
// 234 回文链表
public class IsPalindrome {
    ListNode left = null;
    boolean flag = true;
    public boolean isPalindrome(ListNode head) {
        // 法一，借助递归栈
        left = head;
        return isPalindromeStack(left);
    }

    private boolean isPalindromeStack(ListNode right) {
        if(right == null) {
            return true;
        }
        flag = isPalindromeStack(right.next);
        flag = flag && left.val == right.val;
        left = left.next;
        return flag;
    }

    public boolean isPalindrome2(ListNode head) {
        // 法二，找到中间偏右的节点, 从这往后的链表反转, 然后和头指针依次往后和反转链表比较val
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        ListNode head2 = reverse(slow);
        while (head2 != null) {
            if(head.val != head2.val) {
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
