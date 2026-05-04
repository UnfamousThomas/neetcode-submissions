class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(right >= left) {
            int middle = (left + right) / 2;
            int middleElement = nums[middle];
            if(middleElement == target) return middle;

            if(middleElement > target) {
                right = middle-1;
            } 
            if(middleElement < target) {
                left = middle + 1;
            }
        }
        return -1;
    }
}
