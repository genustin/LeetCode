package easy;

/**
 * Created by Genustin on 12/07/14.
 * <p/>
 * Given a linked list, remove the nth node
 * from the end of list and return its head.
 * <p/>
 * Given n will always be valid.
 * case 0: head is null
 * case 1: remove the head
 * case 2: remove the last
 * case 3: normal remove
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;
        // the flag mark whether the head is removed,
        // if nthPrev moved, then set this flag to false.
        boolean isHeadRemoved = true;
        ListNode ptr = head;
        // nthPrev.next should be nth node from the back.
        ListNode nthPrev = new ListNode(0);
        nthPrev.next = ptr;
        // nth node from the back should be (n - 1) away from the last node
        for (int i = 0; i < n - 1; i++) {
            ptr = ptr.next;
        }
        // move nthPrev
        while (null != ptr.next) {
            ptr = ptr.next;
            nthPrev = nthPrev.next;
            isHeadRemoved = false;
        }

        if (isHeadRemoved)
            return head.next;
        else
            nthPrev.next = nthPrev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = node;
        RemoveNthNodeFromEnd removeNode = new RemoveNthNodeFromEnd();
        removeNode.removeNthFromEnd(head, 2);
    }
}
