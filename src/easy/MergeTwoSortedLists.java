package easy;

/**
 * Created by Genustin on 11/25/2014.
 */
public class MergeTwoSortedLists {

    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // initialize
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode root = new ListNode(0);
        ListNode node = root;

        // merge
        while(null != ptr1 && null != ptr2) {
            while (null != ptr1 && ptr1.val <= ptr2.val) {
                node.next = ptr1;
                node = node.next;
                ptr1 = ptr1.next;
            }
            if (null == ptr1) break;

            while (null != ptr2 && ptr2.val <= ptr1.val) {
                node.next = ptr2;
                ptr2 = ptr2.next;
                node = node.next;
            }
        }

        //handle the tail
        if (null != ptr1)
            node.next = ptr1;
        else if (null != ptr2)
            node.next = ptr2;

        // skip the fake root
        return root.next;
    }
}
