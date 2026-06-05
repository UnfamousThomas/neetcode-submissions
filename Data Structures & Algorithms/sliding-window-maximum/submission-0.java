class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k;
        List<Integer> finalMaximums = new ArrayList<>();
        Deque<Integer> maximums = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!maximums.isEmpty() && nums[maximums.peekLast()] < nums[i]) {
                maximums.removeLast();
            }
            maximums.addLast(i);
        }
        finalMaximums.add(nums[maximums.peekFirst()]);
        while (right < nums.length) {
            while (!maximums.isEmpty() && nums[maximums.peekLast()] < nums[right]) {
                maximums.removeLast();
            }
            maximums.addLast(right);
            if(!maximums.isEmpty() && nums[maximums.peekFirst()] < nums[left]) {
                maximums.removeFirst();
            }
            finalMaximums.add(nums[maximums.peekFirst()]);
            left++;
            right++;
        }
        return finalMaximums.stream().mapToInt(Integer::intValue).toArray();
    }
}
