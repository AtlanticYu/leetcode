package org.example.binarytree;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/07 16:10
 */
//https://www.lintcode.com/problem/597/
// leetcode 1120 vip
// 给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
public class findSubtree2 {
    private double result = Integer.MIN_VALUE;
    private TreeNode node;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        findTree(root);
        return node;
    }

    private Info findTree(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = findTree(root.left);
        Info rightInfo = findTree(root.right);
        int sum = leftInfo.getSum() + rightInfo.getSum() + root.val;
        int step = leftInfo.getStep() + rightInfo.getStep() + 1;
        if ((double) sum / step > result) {
            result = (double) sum / step;
            node = root;
        }
        return new Info(step, sum);
    }

    private class Info {
        private int step;
        private int sum;

        public int getStep() {
            return step;
        }

        public Info(int step, int sum) {
            this.step = step;
            this.sum = sum;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }
}
