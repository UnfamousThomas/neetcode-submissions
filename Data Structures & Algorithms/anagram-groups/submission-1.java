class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String anagram : strs) {
            char[] charArray = anagram.toCharArray();
            Arrays.sort(charArray);
            String coreString = new String(charArray);
            List<String> otherAnagrams = anagrams.getOrDefault(coreString, new ArrayList<String>());
            otherAnagrams.add(anagram);
            anagrams.put(coreString, otherAnagrams);
        }
        return new ArrayList<>(anagrams.values());
    }
}
