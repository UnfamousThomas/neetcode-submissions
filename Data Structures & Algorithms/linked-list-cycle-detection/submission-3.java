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
    // fast pointer and slow pointer algorithm
    public boolean hasCycle(ListNode head) {
        ListNode fast = head; // Intiate both at the head
        ListNode slow = head;

        // Keep going, until fast is null or fast.next is null
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Set fast to the element after the next one
            slow = slow.next; // Set slow to the next element
            if (fast == slow) // If pointers are equal cycle
                return true; // in which case return true
        }

        return false;
    }
}
