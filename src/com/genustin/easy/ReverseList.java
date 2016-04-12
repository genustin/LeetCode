package com.genustin.easy;

/**
 * Created by Genustin on 4/11/16.
 */
public class ReverseList {

    class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode node, prev = null;
        while (head.next != null) {
            node = head.next;
            head.next = prev;
            prev = head;
            head = node;
        }
        head.next = prev;
        return head;
    }
}
