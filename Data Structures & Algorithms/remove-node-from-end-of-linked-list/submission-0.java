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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        LastNode slow = dummy;
        LastNode fast = dummy;

        for(int i = 0; i < n; i++) {
            slow = slow.next;
        }

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(slow.next != null && slow.next.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.head;
    }
}
