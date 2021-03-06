package com.genustin.easy;

import com.genustin.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Genustin on 12/07/14.
 * <p/>
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * Return its bottom-up level order traversal.
 * <p/>
 * case 1: root == null, return an empty list. ie, []
 */
public class P107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        // setup two queues to handle this level and next level
        // if aqueue is not empty, visit each element, put children to bqueue,
        // and vice versa.
        Queue<TreeNode> aqueue = new LinkedList<TreeNode>();
        Queue<TreeNode> bqueue = new LinkedList<TreeNode>();
        // start from aqueue
        if (null != root) aqueue.add(root);
        while (!aqueue.isEmpty() || !bqueue.isEmpty()) {
            if (!aqueue.isEmpty())
                levels.add(0, visit(aqueue, bqueue));
            else
                levels.add(0, visit(bqueue, aqueue));
        }
        return levels;
    }

    private List<Integer> visit(Queue<TreeNode> level, Queue<TreeNode> child) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node;
        while (!level.isEmpty()) {
            node = level.poll();
            list.add(node.val);
            if (null != node.left)
                child.add(node.left);
            if (null != node.right)
                child.add(node.right);
        }
        return list;
    }
}
