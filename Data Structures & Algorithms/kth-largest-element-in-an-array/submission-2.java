class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        //populate queue
        for(int n : nums) {
            queue.add(n);
            if(queue.size() > k) queue.poll();
        }

        //this is somewhat counter intuitivie, but
        // this is a min heap, meaning at the top is the smallest in the current queue
        // since we made sure only k elements were added
        // the smallest is actually kth largest
        return queue.poll();
    }
}
