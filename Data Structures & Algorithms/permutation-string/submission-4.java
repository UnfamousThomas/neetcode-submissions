class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) //If the s1 string is bigger, s2 cannot contain permutations for it
            return false;
        int right = s1.length(); //Right pointer in s2, is equal to the size of s1 initially
        int[] s1Freq = new int[26]; //We track s1 frequencies using an alphabet array
        int[] currentWindowFreq = new int[26]; //Track current window frequencies

        for (int i = 0; i < s1.length(); i++) { //Prepopulate arrays
            currentWindowFreq[s2.charAt(i) - 'a']++; //Current window (to right pointer)
            s1Freq[s1.charAt(i) - 'a']++; //original s1 frequencies
        }

        if (Arrays.equals(currentWindowFreq, s1Freq)) //Since we prepopulated, we need to first check if the two arrays equal
            return true;

        while (right < s2.length()) {
            currentWindowFreq[s2.charAt(right) - 'a']++; //Add new right
            currentWindowFreq[s2.charAt(right - s1.length()) - 'a']--; //Remove previous left pointer
            if (Arrays.equals(currentWindowFreq, s1Freq)) //Check if equal
                return true;
            right++; //Move right one
        }
        return false; //Default ot false
    }
}
