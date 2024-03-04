package org.example.binarytree;

import java.util.*;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/23 19:24
 */
// 2583 二叉树中的第 K 大层和
public class KthLargestLevelSum {
    // 未考虑到两层元素相同的情形
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum);
        }
        if (list.size() < k) return -1;
        Collections.sort(list, Collections.reverseOrder());
        return list.get(k - 1);
    }

    public long kthLargestLevelSum2(TreeNode root, int k) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<Integer, Long> levelSums = new HashMap<>();
        List<Long> list = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(sum);
            levelSums.put(level, sum);
            level++;
        }
        List<Long> sums = new ArrayList<>(levelSums.values());
        if (sums.size() < k) return -1;
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(k - 1);
    }
}
