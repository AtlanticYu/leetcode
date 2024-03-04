package org.example.binarytree;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/21 20:40
 */
// 144 翻转二叉树
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
