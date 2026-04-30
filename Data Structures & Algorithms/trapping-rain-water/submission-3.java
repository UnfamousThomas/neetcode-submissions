class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;

        //Make sure to process case where right = left too.
        while(right >= left) {
            int currentRight = height[right];
            int currentLeft = height[left];

            //If we have a smaller wall on left SIDE
            if(maxLeft < maxRight) {
                maxLeft = Math.max(maxLeft, height[left]); //Update max left if needed
                total += Math.max(Math.min(maxLeft, maxRight) - height[left], 0); //Calculate total based on max, with 0 as lower bound
                left++; 
            } else {
                maxRight = Math.max(maxRight, height[right]); //update max if needed
                total += Math.max(Math.min(maxLeft, maxRight) - height[right],0); //Calculate total based on max, with 0 as a lower bound
                right--;
            }

        }
        return total;
    }
}
