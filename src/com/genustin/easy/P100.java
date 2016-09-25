package com.genustin.easy;

import com.genustin.common.TreeNode;

/**
 * Created by Genustin on 11/19/14.
 *
 * Check whether two tree have same structure and value.
 */
public class P100 {

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
