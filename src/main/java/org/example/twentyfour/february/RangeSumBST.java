package org.example.twentyfour.february;


/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/26 20:20
 */
/// 938 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
public class RangeSumBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        calculate(root, low, high);
        return sum;
    }
    public void calculate(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            calculate(root.right, low, high);
            calculate(root.left, low, high);
            return;
        }
        if (root.val < low) {
            calculate(root.right, low, high);
        } else if (root.val > low) {
            calculate(root.left, low, high);
        }
     }
}
