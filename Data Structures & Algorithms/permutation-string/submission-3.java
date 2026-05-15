class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int right = s1.length();
        int[] s1Freq = new int[26];
        int[] currentWindowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            currentWindowFreq[s2.charAt(i) - 'a']++;
            s1Freq[s1.charAt(i) - 'a']++;
        }

        if (Arrays.equals(currentWindowFreq, s1Freq))
            return true;

        while (right < s2.length()) {
            currentWindowFreq[s2.charAt(right) - 'a']++;
            currentWindowFreq[s2.charAt(right - s1.length()) - 'a']--;
            if (Arrays.equals(currentWindowFreq, s1Freq))
                return true;
            right++;
        }
        return false;
    }
}
