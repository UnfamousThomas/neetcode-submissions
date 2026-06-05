class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequencies = new int[26];
        int maxFreq = 0;
        int maxSubstring = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            frequencies[c - 'A']++;
            maxFreq = Math.max(frequencies[c - 'A'], maxFreq);

            int windowLength = right - left + 1;
            int maximumCurrent = calculateReplacements(windowLength, maxFreq);

            if (maximumCurrent > k) {
                //Maximum current too big, need to shrink and decrease 
                frequencies[s.charAt(left) - 'A']--;
                left++;
            } else {
                maxSubstring = Math.max(maxSubstring, right - left + 1);
                right++;
                //Maximum current too small, expand and track things
            }
        }
        return maxSubstring;
    }
    private int calculateReplacements(int windowLength, int maximumFrequency) {
        return windowLength - maximumFrequency;
    }
}
