class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int neededNum = target - n;
            if(indexes.containsKey(neededNum)) {
                int index = indexes.get(neededNum);
                return new int[]{index, i};
            }
            indexes.put(n, i);
        }
        return new int[0];
    }
}
