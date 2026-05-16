class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[52];
        int[] windowFreq = new int[52];

        int have = 0;
        int need = 0;
        for (char c : t.toCharArray()) {
            int index = calculateIndex(c);
            if(freq[index] == 0) need++; //Uniqueness check for need
            freq[index]++; //Update index count
        }

        int left = 0;
        int right = 0;
        String minimum = "";

        while (right < s.length()) {
            char rightChar = s.charAt(right); //Current right char
            int index = calculateIndex(rightChar); //Calculate the right index

            windowFreq[index]++;
            if (freq[index] == windowFreq[index]) { //Do we have enough of a certain char
                have++; //Then update
            }
            while (have == need) { //If we have the correct num of numbers
                if (minimum.isEmpty() || minimum.length() > right - left) { // right - left + 1 is window length
                    minimum = s.substring(left, right + 1);  //Update minimum if needed
                }
                char leftChar = s.charAt(left);
                int leftIndex = calculateIndex(leftChar);
                windowFreq[leftIndex]--; //Remove old character
                if (windowFreq[leftIndex] < freq[leftIndex]) have--; //Then have can be decreased
                left++; //Shift to the left
            }
            right++; //Shift to the right
        }
        return minimum; //Return the minimum
    }
    int calculateIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A' + 26; //Add 26 to avoid collisions
        } else {
            return c - 'a';
        }
    }
}
