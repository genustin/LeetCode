package com.genustin.easy;

/**
 * Created by Genustin on 11/19/14.
 *
 * Check whether two tree have same structure and value.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q)
            return true;
        else if (null == p || null == q)
            return false;
        else
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
    }
}
