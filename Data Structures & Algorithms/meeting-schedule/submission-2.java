/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    //The thing to think of here is to sort them by start time.
    // Then, we just need to compare every meeting to the next one
    // If next one starts before current ends, they overlap and thus cannot be both attended
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start)); 

        for(int i = 0; i < intervals.size()-1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i+1);

            if(current.end > next.start) return false;
        }
        return true;
    }
}
