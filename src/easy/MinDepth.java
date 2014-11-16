package easy;

/**
 * Created by Genustin on 11/16/14.
 */
public class MinDepth {
    private int min;

    // Definition for binary tree
    private class TreeNode {
        private int      val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
