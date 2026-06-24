class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int remove = 0;
        int activeEndTime = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            //start at one, so need to compare with previous
            if(activeEndTime > intervals[i][0]) {
                //overlap!
                remove++;
                activeEndTime = Math.min(intervals[i][1], activeEndTime);
            } else {
                //no overlap
                activeEndTime = intervals[i][1];
            }
        }
        return remove;
    }
}
