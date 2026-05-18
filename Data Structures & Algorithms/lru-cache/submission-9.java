class LRUCache {
    Map<Integer, Node> nodes = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) { //Initialize the cache
        this.capacity = capacity; //Store the capacity
        head = new Node(0, 0); //Set dummy head
        tail = new Node(0, 0); //Set dummy tail
        head.next = tail; //Set pointer from head to tail
        tail.previous = head; //Set pointer from tail to head
    }

    public int get(int key) {
        Node node = nodes.get(key); //Get node from the map
        if (node == null)
            return -1; //return -1 if doesnt exist

        updateRecentlyUsed(node); //update head correctly
        return node.value; //return value
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) { //if key exists
            Node node = nodes.get(key);
            node.value = value; //update value
            updateRecentlyUsed(node);  //update recently used to maintain cache order
        } else {
            if (nodes.size() + 1 > capacity) { //if capacity is too big
                removeLeastUsed(); //remove least used
            }
            Node node = new Node(value, key); //Create new node object
            insertFront(node); //Insert to the front
            nodes.put(key, node); //Add to the map for lookup later
        }
    }

    private void removeLeastUsed() {
        nodes.remove(tail.previous.key); //Remove from map
        remove(tail.previous); //Remove the actual value from the linked list
    }

    // Remove any node 
    private void remove(Node node) {
        //Update pointers to remove the middle one
        node.previous.next = node.next; 
        node.next.previous = node.previous;
    }

    // Insert right after head
    private void insertFront(Node node) {
        //Pointer after node is the current head
        node.next = head.next;
        //Pointer before node is the dummy head
        node.previous = head; 
        //The element before current head is node
        head.next.previous = node;
        //The element after current DUMMY head is node
        head.next = node;
    }
    //Update the recently used logic
    //Which means removing the node, and then inserting it in the front
    private void updateRecentlyUsed(Node node) {
        remove(node); 
        insertFront(node);
    }

    class Node {
        int value;
        int key;
        Node next;
        Node previous;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }
}
