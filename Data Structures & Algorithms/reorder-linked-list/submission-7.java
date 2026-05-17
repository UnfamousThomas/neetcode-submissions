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
        ListNode middle = findMiddle(head); //Find the middle element
        ListNode secondHalfReversed = reverseLinked(middle.next); //Reverse the half after middle
        middle.next = null; //Set middle next to null to separate them (remove the link)
        interleave(head, secondHalfReversed); //Interleave
    }

    void interleave(ListNode original, ListNode secondHalf) {
        ListNode originalPointer = original;
        ListNode secondPointer = secondHalf;

        while (originalPointer != null && secondPointer != null) { //Continue while both are not null
            ListNode originalNext = originalPointer.next; //Save original nexts since we need them
            ListNode secondNext = secondPointer.next; //but they will be overwritten

            originalPointer.next = secondPointer; //Original next, is now second pointer
            secondPointer.next = originalNext; //and second pointer next, is the originals next
            //This causes interleaving

            originalPointer = originalNext; //Move pointers for next iteration
            secondPointer = secondNext;
        }
    }
    ListNode reverseLinked(ListNode head) {
        ListNode current = head; //Start current from first el
        ListNode next = null;
        ListNode previous = null;

        while (current != null) { //Until we have processed all nodes
            next = current.next; //We set the next element, so that we can update current later
            current.next = previous; //To reverse, we set the next to the previous
            previous = current; //And previous to the current
            current = next; //And then set current to next for next loop
        }

        return previous;
    }
    //Slow and fast pointer algo
    //When fast is at the end, the middle is at middle
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
