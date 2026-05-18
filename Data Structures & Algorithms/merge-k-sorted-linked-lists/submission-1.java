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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node : lists) {
            pq.add(node);
        }

        while(!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            if(smallest.next != null) {
                pq.add(smallest.next);
            }
            current = current.next;
        }

        return dummy.next;
    }
}
