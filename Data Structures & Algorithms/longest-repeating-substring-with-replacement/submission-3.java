class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequencies = new int[26]; //Stores each item frequency
        int maxFreq = 0; //Holds max amount of the same letter
        int maxSubstring = 0; //Holds maximum length of a substring

        int left = 0; //left pointer
        int right = 0; //right pointer

        while (right < s.length()) { //Until right index is less than the length of the string
            char c = s.charAt(right); //Char that is at right pointer
            frequencies[c - 'A']++; //Store right index frequency
            maxFreq = Math.max(frequencies[c - 'A'], maxFreq); //Update max frequency if needed

            int windowLength = right - left + 1; //Length of the current sub string
            int maximumCurrent = calculateReplacements(windowLength, maxFreq); //What the maximum replacements needed in the substring is
            right++; //Always move right pointer, cause we need to always look at next item 
            if (maximumCurrent > k) { //We can only do k replacements
                // Maximum current too big, need to shrink and decrease
                frequencies[s.charAt(left) - 'A']--; //Decrease the amount in the array
                left++; //Increase left pointer, to decrease the size of the window
            } else {
                maxSubstring = Math.max(maxSubstring, windowLength); //Otherwise check if substring is now max
            }
        }
        return maxSubstring;
    }
    private int calculateReplacements(int windowLength, int maximumFrequency) {
        return windowLength - maximumFrequency; //Window length minus most often existing element
    }
}
