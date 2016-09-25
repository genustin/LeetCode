package com.genustin.easy;

import com.genustin.common.TreeNode;

/**
 * Created by Genustin on 11/29/14.
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 */

public class P101 {

    public boolean isSymmetric(TreeNode root) {
        return null == root || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (null == p && null == q)
            return true;
        else if (null == p || null == q)
            return false;
        else
            return p.val == q.val
                    && isMirror(p.left, q.right)
                    && isMirror(p.right, q.left);
    }
}
