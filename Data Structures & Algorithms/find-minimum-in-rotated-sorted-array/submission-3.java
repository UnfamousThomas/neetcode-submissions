class Solution {
    public int findMin(int[] nums) {
        //Rotation is interesting.
        //It basically results in two humps or sub-arrays being made.
        //Both of which are sorted by themselves. 
        // The first hump has bigger numbers than the second one.
        int hi = nums.length - 1;
        int lo = 0;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[hi]) {
                //In this case, the mid element is smaller than current end
                //This means mid is on the second hump/sub-array. In this case either mid itself is the smallest element, or the smallest
                //element is to the left of it on the second hump.
                hi = mid; 
            } else { //so, middle is bigger than hi element
                //Middle being bigger than hi, means that middle is on the first hump. Due to the way rotation works out, the second hump has smaller
                //elements.
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
