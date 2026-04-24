class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #Represents frequencies
        s_map = {}
        t_map = {}

        #Calculate s frequencies
        for letter in s:
            if letter in s_map:
                new_amount = s_map[letter] + 1
                s_map[letter] = new_amount
            else:
                s_map[letter] = 1
        
        # Calculate t frequencie
        for letter in t:
            if letter in t_map:
                new_amount = t_map[letter] + 1
                t_map[letter] = new_amount
            else:
                t_map[letter] = 1

        for letter, amount in s_map.items():
            if letter not in t_map:
                return False
            if amount != t_map[letter]:
                return False

        for letter, amount in t_map.items():
            if letter not in s_map:
                return False
            if amount != s_map[letter]:
                return False

        return True
        
