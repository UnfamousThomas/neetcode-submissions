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
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode lastResult = new ListNode(0);
        ListNode resultDummy = lastResult;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int localSum = 0;
            if (current1 != null) {
                localSum += current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                localSum += current2.val;
                current2 = current2.next;
            }
            localSum += carry;
            carry = localSum / 10;

            lastResult.next = new ListNode(localSum % 10);
            lastResult = lastResult.next;
        }

        if (carry != 0) {
            lastResult.next = new ListNode(carry);
        }

        return resultDummy.next;
    }
}
