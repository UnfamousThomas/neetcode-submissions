class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k;
        List<Integer> finalMaximums = new ArrayList<>(); //Store maximums for each window
        Deque<Integer> maximums = new ArrayDeque<>(); //Store running maximums
        for (int i = 0; i < k; i++) {
            while (!maximums.isEmpty() && nums[maximums.peekLast()] < nums[i]) { //If maximums is not empty
            //and last in the deque is smaller than i
                maximums.removeLast(); //remove the last
            }
            maximums.addLast(i); //Add new last
        }
        finalMaximums.add(nums[maximums.peekFirst()]); //Add the first window to the result

        while (right < nums.length) {
            while (!maximums.isEmpty() && nums[maximums.peekLast()] < nums[right]) {
                //Remove last if maximums is not empty, and right pointer num is bigger than currently stored
                //last element
                maximums.removeLast();
            }
            maximums.addLast(right); //Add new last
            if(!maximums.isEmpty() && maximums.peekFirst() < right - k + 1) {
                //Remove first, if maximum index is outside the window
                maximums.removeFirst();
            }
            finalMaximums.add(nums[maximums.peekFirst()]); //Add to the result
            left++;
            right++;
        }
        return finalMaximums.stream().mapToInt(Integer::intValue).toArray(); //convert to array
    }
}
