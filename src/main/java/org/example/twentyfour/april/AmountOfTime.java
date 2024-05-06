package org.example.twentyfour.april;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 2385
 * @author: rubei
 * @create: 2024/04/24 21:26
 */
// 2385
// 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
public class AmountOfTime {
    int depth = 0;
    int res = 0;
    public int amountOfTime(TreeNode root, int start) {
        // 计算二叉树的深度 + start的深度
        return 0;
    }

    // 递归计算
    public void calculateDepth(TreeNode root) {
        if(root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        calculateDepth(root.left);
        calculateDepth(root.right);
        depth--;
    }

    public int calculateDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = calculateDepth2(root.left);
            int rightDepth = calculateDepth2(root.right);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    //
    // 层序遍历, 求最大深度 + start的深度
    // 这个打答案没有考虑到start可能和最大深度的子节点在一个子树上的情况
    public int calculateDepthAndRes(TreeNode root, int start) {
        int depth = 0;
        int startDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if(node.val == start) {
                    startDepth = depth;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return startDepth + depth - 1;
    }

    // 问题可以转化为:
    // 1 求start为根节点子树的最大深度
    // 2 去除start的子节点, 求精简后子树 计算其中一个端点固定为 3 的 二叉树直径
    public int locationStart(TreeNode root, int start) {
        return 0;
    }
}
