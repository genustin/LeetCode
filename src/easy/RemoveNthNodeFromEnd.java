package easy;

/**
 * Created by Genustin on 12/07/14.
 * <p/>
 * Given a linked list, remove the nth node
 * from the end of list and return its head.
 * <p/>
 * Given n will always be valid.
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;
        if (null == head.next) return null;
        ListNode ptr = head;
        // nthPrev.next should be nth node from the back.
        ListNode nthPrev = head;
        // nth node from the back should have (n - 1) away from the last node,
        // so nthPrev should be (n - 2) away.
        for (int i = 0; i < n - 2; i++) {
            ptr = ptr.next;
        }

        while (null != ptr.next) {
            ptr = ptr.next;
            nthPrev = nthPrev.next;
        }
        if (null != nthPrev.next)
            nthPrev.next = nthPrev.next.next;
        else
            nthPrev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode head = new ListNode(1);
        head.next = node;
        RemoveNthNodeFromEnd removeNode = new RemoveNthNodeFromEnd();
        removeNode.removeNthFromEnd(head, 1);

    }
}
