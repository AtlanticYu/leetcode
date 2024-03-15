package org.example.twentyfour.march;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/21 20:15
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}