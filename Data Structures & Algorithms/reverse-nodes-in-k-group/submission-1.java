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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = countElements(head);
        int element = 0;
        ListNode dummy = new ListNode(0);
        ListNode lastGroupEnd = dummy;
        ListNode currentGroupStart = head;
        
        while(length - element >= k) {
            ReversalInfo info = reverseList(currentGroupStart, k);
            lastGroupEnd.next = info.newHead;
            element += k;
            lastGroupEnd = info.newTail;
            currentGroupStart = info.newTail.next;
        }
        return dummy.next;
    }
    public int countElements(ListNode node) {
        int count = 0;
        ListNode current = node;

        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    ReversalInfo reverseList(ListNode head, int k) {
        ListNode current = head; //Tracks what we are currently iterationg over
        ListNode next = null; //The next in the original linkedlist
        ListNode previous = null; //The previous in the original linkedlist
        while(current != null && k > 0) {
            next = current.next; //Write next to current.next
            current.next = previous; //Current.next is set to previous to reverse the pointer
            previous = current; //Previous is set to current, as we need to prepare for next iteration
            current = next; //And then current is the original next element
            k--;
        }
        head.next = current;
        return new ReversalInfo(previous, head); //At the end of iteration, previous is last non-null ListNode
    }

    class ReversalInfo {
        ListNode newHead;
        ListNode newTail;

        ReversalInfo(ListNode newHead, ListNode newTail) {
            this.newHead = newHead;
            this.newTail = newTail;
        }
    }
}
