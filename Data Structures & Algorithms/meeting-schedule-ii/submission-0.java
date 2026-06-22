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
    //This is quite hard to be honest.
    // But I think the best solution is to compare the next meeting start vs earlier meeting end.
    // The earlier ends represents when a room becomes free.
    // If start is before earliest end, we need another room
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) return 0;

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endPointer = 0;

        for(int i = 0; i < n; i++) {
            if(starts[i] < ends[endPointer]) {
                rooms++;
            } else {
                endPointer++; //Frees a room
            }
        }
        return rooms;
    }
}
