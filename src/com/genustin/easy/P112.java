package com.genustin.easy;

import com.genustin.common.TreeNode;

/**
 * Created by Genustin on 11/15/14.
 *
 * PreOrder, recursion
 */

public class P112 {

    // flag
    private boolean isPathFind;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        this.isPathFind = false;
        int path = 0;
        preOrder(root, path, sum);
        return this.isPathFind;
    }

    private void preOrder(TreeNode node, int path, final int sum) {
        if (this.isPathFind)
            return;

        if (null == node.left && null == node.right) {
            this.isPathFind = path + node.val == sum;
            return;
        }

        if (null != node.left)
            preOrder(node.left, path + node.val, sum);

        if (null != node.right)
            preOrder(node.right, path + node.val, sum);
    }
}



