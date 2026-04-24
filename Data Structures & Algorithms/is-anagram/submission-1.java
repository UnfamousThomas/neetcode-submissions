class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int occurances = freq.getOrDefault(currentChar, 0);
            occurances += 1;
            freq.put(currentChar, occurances);
        }

        for (int j = 0; j < t.length(); j++) {
            char currentChar = t.charAt(j);
            if(!freq.containsKey(currentChar)) return false;

            int occurances = freq.get(currentChar);
            if(occurances == 0) return false;
            int newOcc = occurances - 1;
            if(newOcc == 0) {
                freq.remove(currentChar);
            } else {
                freq.put(currentChar, newOcc);
            }
            
        }

        return freq.isEmpty();
    }
}
