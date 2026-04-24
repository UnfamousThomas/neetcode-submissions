from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for anagram in strs:
            frequencies = [0] * 26
            for letter in anagram:
                letter_index = ord(letter) - ord('a')
                frequencies[letter_index] = frequencies[letter_index] + 1
            anagrams[tuple(frequencies)].append(anagram)
        return list(anagrams.values())