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
        ListNode leftPointer = list1; //iterator for list 1
        ListNode rightPointer = list2; //iterator for list 2
        ListNode dummy = new ListNode(0); //Dummy for knowing what to return
        ListNode current = dummy; //Last processed element

        while (leftPointer != null || rightPointer != null) {
            if (leftPointer == null) { //If left is null, use right and return
                // use right pointer
                current.next = rightPointer;
                rightPointer = rightPointer.next;
                return dummy.next;
            }
            if (rightPointer == null) { //If right is null, use left and return
                // use left pointer
                current.next = leftPointer;
                leftPointer = leftPointer.next;
                return dummy.next;
            }
            if (leftPointer.val > rightPointer.val) { //If left is bigger, use right
                // use right
                current.next = rightPointer; //Set next element to the right
                current = rightPointer; //Set last processed
                rightPointer = rightPointer.next; //Move right
            } else {
                // use left
                current.next = leftPointer; //Set next element to the left
                current = leftPointer; //Set last processed
                leftPointer = leftPointer.next; //Move left
            }
        }
        return dummy.next; //return first real element
    }
}