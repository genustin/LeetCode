package com.genustin.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by wayne on 16/2/29.
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    //this takes 0 ms in leetcode
    public TreeNode invertTree(TreeNode root) {
        postOrder(root);
        return root;
    }

    void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }

    // this take 2 ms in leetcode, why this slower?
    public TreeNode invertTree2(TreeNode root) {
        Deque<TreeNode> st = new LinkedList<TreeNode>();
        TreeNode cur;
        TreeNode pre = null;

        st.push(root);
        while (!st.isEmpty() && st.peek() != null) {
            cur = st.peek();
            if ((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))) {
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                st.pop();
                pre = cur;
            } else {
                if (cur.left != null) {
                    st.push(cur.left);
                }

                if (cur.right != null) {
                    st.push(cur.right);
                }
            }
        }
        return root;
    }
}