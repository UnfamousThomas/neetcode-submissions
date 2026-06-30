class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] output = new int[queries.length];
        int[][] indexedQueries = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        int j = 0;

        for(int[] querry : indexedQueries) {
            int querryNum = querry[0];
            while(j < intervals.length && intervals[j][0] <= querryNum) {
                minHeap.add(intervals[j]);
                j++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < querryNum) {
                minHeap.poll();
            }
    
            if(!minHeap.isEmpty()) {
                output[querry[1]] = minHeap.peek()[1] - minHeap.peek()[0] + 1;
            } else {
                output[querry[1]] = -1;
            }
        }
        return output;
    }
}
