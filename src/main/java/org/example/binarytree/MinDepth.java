package org.example.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/01/25 16:27
 */
// 111. 二叉树的最小深度
public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                // 二叉树的最小高度
                if (current.left == null && current.right == null) {
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }
}
