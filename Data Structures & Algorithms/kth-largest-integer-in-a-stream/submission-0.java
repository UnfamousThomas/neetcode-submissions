class KthLargest {
    int k;
    int[] nums;
    Queue<Integer> stream = new PriorityQueue();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums; 
        for(int n : nums) {
            addToStream(n);
        }   
    }
    
    public int add(int val) {
        addToStream(val);
        return stream.peek();
    }

    private void addToStream(int val) {
        stream.add(val);
        if(stream.size() > k) {
            stream.poll();
        }
    }
}
