package org.example.binarytree;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/21 20:12
 */
// 给你一棵二叉树的根节点，返回该树的 直径 。
//
//二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
//
//两节点之间路径的 长度 由它们之间边数表示。
public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDiameter = Math.max(left + right, maxDiameter);
        return 1 + Math.max(left, right);
    }
}
