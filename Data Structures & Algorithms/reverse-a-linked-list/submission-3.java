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
    public ListNode reverseList(ListNode head) {
        ListNode current = head; //Tracks what we are currently iterationg over
        ListNode next = null; //The next in the original linkedlist
        ListNode previous = null; //The previous in the original linkedlist
        while(current != null) {
            next = current.next; //Write next to current.next
            current.next = previous; //Current.next is set to previous to reverse the pointer
            previous = current; //Previous is set to current, as we need to prepare for next iteration
            current = next; //And then current is the original next element
        }
        return previous; //At the end of iteration, previous is last non-null ListNode
    }
}
