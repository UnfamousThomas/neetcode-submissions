class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;

        // Make sure to process case where right = left too.
        while (right >= left) {
            // If we have a smaller wall on left SIDE
            if (maxLeft < maxRight) {
                maxLeft = Math.max(maxLeft, height[left]); // Update max left if needed
                total += calculateWaterLevel(maxLeft, maxRight, height[left]);
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]); // update max if needed
                total += calculateWaterLevel(maxLeft, maxRight, height[right]);
                right--;
            }
        }
        return total;
    }

    /**
    Calculates the water level based on:
    - The maximum wall to the left
    - The maximum wall to the right
    - Current position floor level

    You can think of this, as if you are standing on the floor, and have walls on both sides, how
    high does the water go?
    *
  */
    private int calculateWaterLevel(int maxWallOnLeft, int maxWallOnRight, int floorLevel) {
        int minimumWall = Math.min(maxWallOnLeft, maxWallOnRight);
        int waterLevel = minimumWall - floorLevel;
        return Math.max(waterLevel, 0);
    }
}
