class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> duplicates = new HashSet<>();
        while (right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!duplicates.contains(rightChar)) {
                duplicates.add(rightChar);
                right++;
                max = Math.max(max, right - left);
            } else {
                while (duplicates.contains(rightChar)) {
                    duplicates.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return max;
    }
}
