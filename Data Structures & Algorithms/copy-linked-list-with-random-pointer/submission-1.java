/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //We need to somehow store the "matching" nodes
        Map<Node, Node> nodes = new HashMap<>(); 
        Node copiedDummy = new Node(0);
        Node copiedPointer = copiedDummy;
        Node originalPointer = head;
        while(originalPointer != null) {
            Node newNode = new Node(originalPointer.val);
            nodes.put(originalPointer, newNode);
            copiedPointer.next = newNode;
            copiedPointer = copiedPointer.next;
            originalPointer = originalPointer.next;
        }

        originalPointer = head;
        copiedPointer = copiedDummy;

        while(originalPointer != null) {
            if(originalPointer.random != null) {
                copiedPointer.random = nodes.get(originalPointer.random);
            }
            originalPointer = originalPointer.next;
            copiedPointer = copiedPointer.next;
        }

        return copiedDummy.next;
    }
}
