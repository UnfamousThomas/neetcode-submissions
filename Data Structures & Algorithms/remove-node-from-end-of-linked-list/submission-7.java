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
        ListNode dummy = new ListNode(0, head); //Store a dummy node for making the gap
        ListNode slow = dummy; //Slow is the left pointer
        ListNode fast = dummy; //Fast is the right pointer

        for(int i = 0; i < n; i++) { //Runs n times, so the fast pointer is now has a gap of n-1
            fast = fast.next; //Move
        }

        while(fast != null && fast.next != null) { //Run until fast is at the end
            fast = fast.next; //Move pointers (both by 1)
            slow = slow.next;
        }

        if(slow.next != null) { //Because we had a n-1 gap, slow is now at n-1th from the end
            slow.next = slow.next.next; //So we can just set the next to the one after nth
        }

        return dummy.next; //And return the head
    }
}
