package com.genustin.medium;

import com.genustin.common.ListNode;

/**
 * Created by Genustin on 4/13/16.
 * <p>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode node1 = l1, node2 = l2, newNode;
        while (node1 != null && node2 != null) {
            int val = node1.val + node2.val + carry;
            newNode = new ListNode(val % 10);
            tail.next = newNode;
            tail = tail.next;
            // next loop
            carry = val / 10;
            node1 = node1.next;
            node2 = node2.next;
        }

        // clean list
        ListNode node;
        if (node1 != null) node = node1;
        else node = node2;

        while (node != null) {
            int val = node.val + carry;
            newNode = new ListNode(val % 10);
            tail.next = newNode;
            tail = tail.next;
            // next loop
            carry = val / 10;
            node = node.next;
        }

        // clean carry
        while (carry != 0) {
            newNode = new ListNode(carry % 10);
            tail.next = newNode;
            carry = carry / 10;
        }

        return head.next;
    }
}
