package easy;

import common.ListNode;

/**
 * Created by Genustin on 12/21/14.
 * find the node at which the intersection of two singly linked lists begins,
 * return null if no intersection.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA, lenB;
        if (null != headA && null != headB) {
            lenA = 1;
            lenB = 1;
        } else
            return null;

        // go through the two lists.
        ListNode nodeA, nodeB;
        nodeA = headA;
        nodeB = headB;
        while (null != nodeA.next) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (null != nodeB.next) {
            nodeB = nodeB.next;
            lenB++;
        }

        // the two list ends are different, so no intersection.
        if (!nodeA.equals(nodeB)) return null;

        // try to find the intersection point.
        nodeA = headA;
        nodeB = headB;
        if (lenA >= lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                nodeB = nodeB.next;
            }
        }

        while (!nodeB.equals(nodeA)) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }
}
