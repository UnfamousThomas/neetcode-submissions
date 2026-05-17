/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode secondHalfReversed = reverseLinked(middle.next);
        middle.next = null;
        interleave(head, secondHalfReversed);
    }

    void interleave(ListNode original, ListNode secondHalf) {
        ListNode originalPointer = original;
        ListNode secondPointer = secondHalf;

        while (originalPointer != null && secondPointer != null) {
            ListNode originalNext = originalPointer.next;
            ListNode secondNext = secondPointer.next;

            originalPointer.next = secondPointer;
            secondPointer.next = originalNext;

            originalPointer = originalNext;
            secondPointer = secondNext;
        }
    }
    ListNode reverseLinked(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    ListNode findMiddle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}
