class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxSize = 0;

        while(right > left) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            int length = right - left;
            int size = length * Math.min(leftHeight, rightHeight);
            maxSize = Math.max(maxSize, size);

            if(leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return maxSize;  
    }
}
