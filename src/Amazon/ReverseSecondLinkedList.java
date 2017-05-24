package Amazon;

import java.util.List;

/**
 * Created by shiyanch on 1/19/17.
 */
public class ReverseSecondLinkedList {
    static class ListNode {
        int x;
        ListNode next;
        public ListNode(int x) {
            this.x = x;
        }
    }
    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode walker = head;
        ListNode runner = head;

        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }

        reverse(walker);
        return head;
    }

    private static void reverse(ListNode walker) {
        ListNode secHalf = walker.next;
        ListNode cur = secHalf.next;
        while (cur != null) {
            secHalf.next = cur.next;
            cur.next = walker.next;
            walker.next = cur;
            cur = secHalf.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i=1; i<5; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = tail.next;
        }

        ListNode newHead = reverseSecondHalfList(head);
        while (newHead != null) {
            System.out.print(newHead.x+" ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}
