package com.genustin.easy;

/**
 * Created by Genustin on 11/16/14.
 * <p/>
 * a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (null == root) return true;
        int left = preOrderDepth(root.left, 1);
        int right = preOrderDepth(root.right, 1);

        if (left - right > 1 || left - right < -1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int preOrderDepth(TreeNode node, int depth) {
        if (null == node)
            return depth - 1;

        if (null == node.left && null == node.right)
            return depth;

        int left  = preOrderDepth(node.left, depth + 1);
        int right = preOrderDepth(node.right, depth + 1);

        return left > right ? left : right;
    }
}
