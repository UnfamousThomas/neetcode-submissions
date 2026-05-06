class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > nums[hi]) {
                // left side
                if (target >= nums[0] && target <= nums[mid]) {
                    // If this is true, element on left hump.
                    hi = mid - 1;
                } else {
                    // Element on the right hump
                    // Need to move to the right more
                    lo = mid + 1;
                }
            } else {
                // mid cuurrently on the right side
                if (target >= nums[mid] && target <= nums[hi]) {
                    // If this is true, element on the right hump
                    // Need to decrease area
                    // So basically, searching for whats right of mid
                    lo = mid + 1;
                } else {
                    // Element to the left of mid (left bump)
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
