class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int k = i + 1;
            int j = nums.length - 1;
            int current = nums[i];

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (k < j) {
                int sum = nums[k] + nums[j];
                if (sum == -current) {
                    List<Integer> subResults = List.of(current, nums[k], nums[j]);
                    result.add(subResults);

                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j] == nums[j - 1]) j--;

                    k++;
                    j--;
                } else if (sum > -current) {
                    j--;
                } else {
                    k++;
                }
            }
        }
        return result;
    }
}
