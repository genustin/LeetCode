package com.genustin.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Genustin on 11/15/14.
 * <p>
 * PostOrder, non-recursion
 */
public class PathSumNR {
    /**
     * Binary tree and a visit flag
     */
    private class TreeNodeVisit {
        private TreeNode node;
        private boolean  isFirst;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        Deque<TreeNodeVisit> stack = new LinkedList<TreeNodeVisit>();
        int pathSum = 0;
        TreeNodeVisit nodeVisit;
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                nodeVisit = new TreeNodeVisit();
                nodeVisit.node = node;
                nodeVisit.isFirst = true;
                stack.push(nodeVisit);
                pathSum += node.val;
                node = node.left;
            }

            if (!stack.isEmpty()) {
                nodeVisit = stack.pop();
                node = nodeVisit.node;
                // leaf
                if (null == node.left && null == node.right)
                    if (pathSum == sum)
                        return true;

                if (nodeVisit.isFirst) {
                    // push back
                    nodeVisit.isFirst = false;
                    stack.push(nodeVisit);
                    node = node.right;
                } else {
                    // real pop
                    pathSum -= node.val;
                    node = null;
                }
            }
        }
        return false;
    }
}
