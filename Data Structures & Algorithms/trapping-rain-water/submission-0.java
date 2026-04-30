class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while(right >= left) {
            int currentRight = height[right];
            int currentLeft = height[left];

            if(maxLeft < maxRight) {
                //process left
                maxLeft = Math.max(maxLeft, height[left]);
                total += Math.max(Math.min(maxLeft, maxRight) - height[left], 0);
                left++; //what should i be
            } else {
                maxRight = Math.max(maxRight, height[right]);
                total += Math.max(Math.min(maxLeft, maxRight) - height[right],0);
                right--;
                //process right
            }

        }
        return total;
    }
}
