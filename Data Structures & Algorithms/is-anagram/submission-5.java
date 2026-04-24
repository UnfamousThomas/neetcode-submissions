class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        if(s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            freq[currentChar - 'a']++;;
        }

        for (int j = 0; j < t.length(); j++) {
            char currentChar = t.charAt(j);
            if(freq[currentChar - 'a'] == 0) return false;
            freq[currentChar - 'a']--;;
            
        }

        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
