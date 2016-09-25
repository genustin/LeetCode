package com.genustin.hard;

import com.genustin.common.RandomListNode;

/**
 * Created by wayne on 16/4/12.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */

public class P138 {
    /**
     * Definition for singly-linked list with a random pointer.
     */


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode node = head;
        RandomListNode copyNode;

        while (node != null) {
            // construct new copied copyNode
            copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            // insert after the original node.
            node.next = copyNode;
            node = copyNode.next;
        }

        // 坑:必须先循环设置random,然后循环拆链表, 不能边修改random边拆解两个链表
        node = head;
        while (node != null) {
            // reset copyNode random ptr
            if (node.random != null)
                node.next.random = node.random.next;
            else
                node.next.random = null;
            // move node, skip copyNode
            node = node.next.next;
        }

        node = head;
        RandomListNode copyHead = head.next;
        while (node != null) {
            copyNode = node.next;
            // split two chains, reset next
            node.next = copyNode.next;
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }
            // move node, already skip copyNode
            node = node.next;
        }
        return copyHead;
    }

    public static void main(String [] args) {
        int [] li = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RandomListNode head = new RandomListNode(0);
        head.next = null;
        head.random = head;
        for (int i = 0; i < li.length; i++) {
            RandomListNode node = new RandomListNode(li[i]);
            node.next = head;
            node.random = head;
            head = node;
        }

        RandomListNode node = head;
        while (node != null) {
            System.out.println("init:" + node.label);
            node = node.next;
        }

        P138 copyListWIthRandomPtr = new P138();
        RandomListNode copyHead = copyListWIthRandomPtr.copyRandomList(head);

        while (head != null) {
            System.out.println("origin:" + head.label);
            System.out.println("origin-random:" + head.random.label);
            head = head.next;
        }

        while (copyHead != null) {
            System.out.println("copyed:" + copyHead.label);
            System.out.println("copyed-random:" + copyHead.random.label);
            copyHead = copyHead.next;
        }
    }


}
