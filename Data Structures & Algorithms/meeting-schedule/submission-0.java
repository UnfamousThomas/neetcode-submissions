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
    //so...
    // The goal here is to check every meeting against every other meeting, to see if it conflicts
    // The conflict itself is an if check
    // However, the challenge in reality is how to do the checks.
    // The solution I can come up with is just a O(n**2) (a for loop in a for loop) but
    // that sucks complexity wise.
    // We probably need some data structure but im not sure what

    //Actually, maybe the solution is sorting?
    //If I sort them by start time, then I can probably compare only with the next?
    // If the next starts before current ends, it returns false
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
