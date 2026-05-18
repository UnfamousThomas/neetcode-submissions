class LRUCache {
    Map<Integer, Node> nodes = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = nodes.get(key);
        if (node == null)
            return -1;

        updateRecentlyUsed(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.value = value;
            updateRecentlyUsed(node);
        } else {
            if (nodes.size() + 1 > capacity) {
                removeLeastUsed();
            }
            Node node = new Node(value, key);
            insertFront(node);
            nodes.put(key, node);
        }
    }

    private void removeLeastUsed() {
        nodes.remove(tail.previous.key);
        remove(tail.previous);
    }

    // Remove any node (no null checks needed!)
    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Insert right after head (most recently used)
    private void insertFront(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }
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
