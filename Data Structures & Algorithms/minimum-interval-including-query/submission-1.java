class Solution {
    //I hated this with a passion
    // The idea itself is that we need to find the smallest interval for each querry
    // so that the querry fits inside the interval

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] output = new int[queries.length];
        int[][] indexedQueries = new int[queries.length][2];

        //Load querries into an array, with their original indexes saved
        for(int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new int[]{queries[i], i};
        }
        //Sort both querries and intervals based on their start time
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        //Add a minheap that sorts based on the length of intervals
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        int j = 0;

        //For every querry
        for(int[] querry : indexedQueries) {
            int querryNum = querry[0];
            //If the interval start time is smaller than querry
            while(j < intervals.length && intervals[j][0] <= querryNum) {
                //Add to the heap
                minHeap.add(intervals[j]);
                j++;
            }
            //If the interval end is smaller than querry
            while(!minHeap.isEmpty() && minHeap.peek()[1] < querryNum) {
                minHeap.poll();
            }
    
            //Finally, if the heap is not empty, that is the answer
            if(!minHeap.isEmpty()) {
                //Need to save it at original index, as the interval size
                output[querry[1]] = minHeap.peek()[1] - minHeap.peek()[0] + 1;
            } else {
                //If it was empty, we did not find a result, so -1
                output[querry[1]] = -1;
            }
        }
        return output;
    }
}
