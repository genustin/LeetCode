package easy;

/**
 * Created by Genustin on 11/24/14.
 * <p/>
 * Given a sorted linked list, delete all duplicates
 * such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicateFromSortedList {
    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
        private int      val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;

        ListNode last = head;
        ListNode node = head;
        while (null != node) {
            // skip all the duplicates
            while (null != node.next && node.val == node.next.val)
                node = node.next;
            // add the first to the end
            node = node.next;
            last.next = node;
            last = last.next;
        }
        return head;
    }
}
