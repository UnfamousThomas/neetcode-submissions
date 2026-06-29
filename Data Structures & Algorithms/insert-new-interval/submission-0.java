class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // so, at it's core, its a similar interval thing
        // The question here is, to first find the interval index
        // Then compare with index+1 and -1 to see what needs to be merged
        List<int[]> results = new ArrayList<>();
        int i = 0;
        //Phase 1: If interval before the new interval, add it
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i]);
            i++;
        }
        //Phase 2: If interval start time, is less than or equal to new interval end, merge them into one
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            i++;
        }
        //Add the interval
        results.add(newInterval);
        //Add missing intervals after the added one
        while (i < intervals.length) {
            results.add(intervals[i]);
            i++;
        }
        return results.toArray(new int[0][]);
    }
}
