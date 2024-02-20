package org.example.chaintable;

import java.util.PriorityQueue;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/05 18:15
 */
// 23 给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
// todo 超时, 待debug
// labuladong的解法为使用PriorityQueue<ListNode> pq = new PriorityQueue<>(
//        lists.length, (a, b)->(a.val - b.val));
    // 取出的头节点即为最小值，然后把next再次放入
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = dummy;
        ListNode[] p = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i++) {
            p[i] = lists[i];
        }
        int cursor = findMin(p);
        while (cursor != -1) {
            if (lists[cursor] != null) {
                ListNode temp = lists[cursor].next;
                p1.next = lists[cursor];
                p1 = p1.next;
                p1.next = null;
                lists[cursor] = temp;
                p[cursor] = temp;
                cursor = findMin(p);
            }
        }
        return dummy.next;
    }

    public int findMin(ListNode[] lists) {
        int minNum = 99999;
        int cursor = -1;
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minNum = Math.min(minNum, lists[i].val);
                if (lists[i].val == minNum) {
                    cursor = i;
                }
            }
        }
        return cursor;
    }

    // 优先队列解法
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for(int i = 0; i < lists.length; i++) {
            queue.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p1 = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p1.next = node;
            p1 = p1.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
