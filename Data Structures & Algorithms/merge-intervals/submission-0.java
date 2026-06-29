class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(currentEnd >= intervals[i][0]) {
                //overlap
                currentEnd = Math.max(currentEnd, intervals[i][1]);
                continue;
            }
            mergedIntervals.add(new int[]{currentStart, currentEnd});
            currentStart = intervals[i][0];
            currentEnd = intervals[i][1];
            //does not overlap
        }
        mergedIntervals.add(new int[]{currentStart, currentEnd});  // Add the last one
        return mergedIntervals.toArray(new int[0][]);
    }
}
