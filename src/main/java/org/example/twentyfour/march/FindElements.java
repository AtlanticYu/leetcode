package org.example.twentyfour.march;


/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/12 22:54
 */
public class FindElements {

    TreeNode root;
    public FindElements(TreeNode root) {
        root.val = 0;
        recoverTree(root);
        this.root = root;
    }

    public boolean find(int target) {
        return search(this.root, target);
    }

    private void recoverTree(TreeNode root) {
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            recoverTree(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            recoverTree(root.right);
        }
    }

    private boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val > target) {
            return false;
        }
        boolean left = root.left == null ? false : search(root.left, target);
        boolean right = root.right == null ? false : search(root.right, target);
        return left || right;
    }
}
