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
        //Dummy to return the result later
        Node copiedDummy = new Node(0);
        //Pointer to store the copied node
        Node copiedPointer = copiedDummy;
        //Pointer to store the original node
        Node originalPointer = head;

        //Initial loop to make new nodes
        while(originalPointer != null) {
            //New node, which is a copy with the same value
            Node newNode = new Node(originalPointer.val);
            //Add new node into the hashmap, with the original node as a pointer
            nodes.put(originalPointer, newNode);
            
            //Setup the pointer for copy
            copiedPointer.next = newNode;

            //Move the pointers
            copiedPointer = copiedPointer.next;
            originalPointer = originalPointer.next;
        }

        //Reset pointers
        originalPointer = head;
        copiedPointer = copiedDummy.next;

        //Second pointers for randoms
        while(originalPointer != null) {
            //If random was not null originally
            if(originalPointer.random != null) {
                //Since we passed over the list already, we can just get it and set the pointer
                copiedPointer.random = nodes.get(originalPointer.random);
            }

            //Move pointers forward
            originalPointer = originalPointer.next;
            copiedPointer = copiedPointer.next;
        }

        //Return result
        return copiedDummy.next;
    }
}
