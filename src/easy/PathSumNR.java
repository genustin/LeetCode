package easy;

import java.util.Stack;

/**
 * Created by Genustin on 11/15/14.
 *
 * PostOrder, non-recursion
 */
public class PathSumNR {

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

    /**
     * Binary tree and a visit flag
     */
    private class TreeNodeVisit {
        private TreeNode node;
        private boolean  isFirst;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNodeVisit> stack = new Stack<TreeNodeVisit>();
        int pathSum = 0;
        TreeNodeVisit nodeVisit;
        TreeNode node = root;
        while (null != node || !stack.empty()) {
            while (null != node) {
                nodeVisit = new TreeNodeVisit();
                nodeVisit.node = node;
                nodeVisit.isFirst = true;
                stack.push(nodeVisit);
                pathSum += node.val;
                node = node.left;
            }

            if (!stack.empty()) {
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
