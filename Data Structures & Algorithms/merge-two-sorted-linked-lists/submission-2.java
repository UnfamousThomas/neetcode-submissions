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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode leftPointer = list1;
      ListNode rightPointer = list2;
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;

      while(leftPointer != null || rightPointer != null) {
        if(leftPointer != null && leftPointer.val > rightPointer.val) {
            //use l1
            current.next = leftPointer;
            current = leftPointer;
            leftPointer = leftPointer.next;
        } else {
            //use l2
            current.next = rightPointer;
            current = rightPointer;
            rightPointer = rightPointer.next;
        }
      }
      return dummy.next;
    }
}