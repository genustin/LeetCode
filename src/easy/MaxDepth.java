package easy;

/**
 * Created by Genustin on 11/16/14.
 */
public class MaxDepth {
    private int max;

    // Definition for binary tree
    private class TreeNode {
        private int      val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        max = -1;
        if (null == root) return 0;
        preOrder(root, 1);
        return max;
    }

    private void preOrder(TreeNode node, int depth) {

        if (null == node.left && null == node.right)
            max = max > depth ? max : depth;

        if (null != node.left)
            preOrder(node.left, depth + 1);

        if (null != node.right)
            preOrder(node.right, depth + 1);
    }

}
