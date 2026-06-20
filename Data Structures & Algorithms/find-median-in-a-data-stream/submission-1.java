class MedianFinder {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        maxHeap.add(num);

        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int tooBig = maxHeap.poll();
            minHeap.add(tooBig);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }

        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return minHeap.peek();
    }
}
