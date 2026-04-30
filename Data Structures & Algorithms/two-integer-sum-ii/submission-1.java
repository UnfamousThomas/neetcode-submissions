class Solution {
       public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                //This is for 1-indexed
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                //If the sum is too small, we move the left side, thus increasing the number
                left++;
            } else {
                //If the sum is too big, we move the right side, thus decreasing the number
                right--;
            }
        }

        return new int[0];
    }
}
