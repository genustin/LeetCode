package easy;

/**
 * Created by Genustin on 11/15/14.
 *
 * PreOrder, recursion
 */

public class PathSum {

    // flag
    private boolean isPathFind;

    /**
     * Definition for binary tree
     */
    private class TreeNode {
        private int      val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        this.isPathFind = false;
        int path = 0;
        go(root, path, sum);
        return this.isPathFind;
    }

    private void go(TreeNode node, int path, int sum) {
        if (this.isPathFind)
            return;

        if (null == node.left && null == node.right) {
            this.isPathFind = path + node.val == sum;
            return;
        }

        if (null != node.left)
            go(node.left, path + node.val, sum);

        if (null != node.right)
            go(node.right, path + node.val, sum);
    }
}



