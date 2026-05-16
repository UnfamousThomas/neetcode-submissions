class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[52];
        int[] windowFreq = new int[52];

        int have = 0;
        int need = 0;
        for (char c : t.toCharArray()) {
            int index = calculateIndex(c);
            if(freq[index] == 0) need++;
            freq[index]++;
        }

        int left = 0;
        int right = 0;
        String minimum = "";

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            int index = calculateIndex(rightChar);

            windowFreq[index]++;
            if (freq[index] == windowFreq[index]) {
                have++;
            }
            while (have == need) {
                if (minimum.isEmpty() || minimum.length() > right - left) {
                    minimum = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                int leftIndex = calculateIndex(leftChar);
                windowFreq[leftIndex]--;
                if (windowFreq[leftIndex] < freq[leftIndex])
                    have--;
                left++;
            }
            right++;
        }
        return minimum;
    }
    int calculateIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A' + 26;
        } else {
            return c - 'a';
        }
    }
}
