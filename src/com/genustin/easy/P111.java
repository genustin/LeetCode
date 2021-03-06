package com.genustin.easy;

import com.genustin.common.TreeNode;

/**
 * Created by Genustin on 11/16/14.
 */
public class P111 {
    private int min;

    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        this.min = -1;
        preOrder(root, 1);
        return min;
    }

    private void preOrder(TreeNode node, int depth) {
        if (null == node.left && null == node.right)
            if (min < 0)
                min = depth;
            else
                min = min < depth ? min : depth;

        if (null != node.left)
            preOrder(node.left, depth + 1);

        if (null != node.right)
            preOrder(node.right, depth + 1);
    }
}
