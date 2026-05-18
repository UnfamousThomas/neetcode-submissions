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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1; //Store pointer for l1
        ListNode current2 = l2; //Store pointer for l2
        ListNode lastResult = new ListNode(0); //Last result pointer
        ListNode resultDummy = lastResult; //Dummy for returning
        int carry = 0; //Operation carry over

        while (current1 != null || current2 != null) {
            int localSum = 0; //What the local sum is
            if (current1 != null) { //We do not need to add if pointer does not exist
                localSum += current1.val; //Add value
                current1 = current1.next; //Move current forward
            }
            if (current2 != null) {
                localSum += current2.val;
                current2 = current2.next;
            }
            localSum += carry; //Add carry to the sum
            carry = localSum / 10; //Calculate carry

            lastResult.next = new ListNode(localSum % 10); //Calculate sum without carry and store as listnode
            lastResult = lastResult.next; //Move lastresult forward
        }

        if (carry != 0) { //in case carry was leftover
            lastResult.next = new ListNode(carry); //Add carryover
        }

        return resultDummy.next;
    }
}
