class Solution {
        public boolean hasDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int n : nums) {
            if(values.contains(n)) return true;
            values.add(n);
        }
        return false;
    }
}