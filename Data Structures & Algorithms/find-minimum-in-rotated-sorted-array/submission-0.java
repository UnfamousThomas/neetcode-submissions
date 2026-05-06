class Solution {
    public int findMin(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int midEl = nums[mid];
            if(midEl < nums[hi]) {
                hi = mid; //shifts to the left
            } else {
                //num is bigger or equal
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
