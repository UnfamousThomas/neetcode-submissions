class LRUCache {
    Map<Integer, Node> nodes = new HashMap<>();
    Node first;
    Node last;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        Node node = nodes.get(key);
        if(node == null) return -1;

        node.previous.next = node.next;
        node.next.previous = node.previous;

        node.previous = null;
        node.next = null;
        node.next = first;
        first = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        if(nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.value = value;
            node.next = first;
            node.previous = null;
            first = node;
        } else {
            if(nodes.size() + 1 > capacity) {
                removeLeastUsed();
            }
            Node node = new Node(value, key);
            node.next = first;
            first = node;
            nodes.put(key, node);
        }
    }

    private void removeLeastUsed() {
        if(last == null) return;
        Node lastNode = last;
        last = last.previous;
        nodes.remove(lastNode.key);
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
