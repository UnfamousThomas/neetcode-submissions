class MedianFinder {
    //LOWER HALF of all numbers. Top is the smallest of the largst half.
    private Queue<Integer> minHeap = new PriorityQueue<>();
    //HIGHER HALF of all numbers. Top is the largest of smallest half
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        //Presume second half initially
        maxHeap.add(num);

        //If the largest of smallest half is larger than smallest of largest half, move the smallest
        // of largest to the other half.
        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int tooBig = maxHeap.poll();
            minHeap.add(tooBig);
        }

        //Balance the two heaps, so their size has a maximum difference of 1.
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
