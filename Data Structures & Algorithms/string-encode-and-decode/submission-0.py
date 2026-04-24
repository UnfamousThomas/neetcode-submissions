class Solution:
    # [LENGTH]#[STRING]
    def encode(self, strs: List[str]) -> str:
        encoded = []
        for s in strs:
            encoded.append(f"{len(s)}#{s}")
        return "".join(encoded)

            
    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
        # find the separator
            j = i
            while s[j] != '#':
                j += 1

            length = int(s[i:j])
            j += 1  # move past '#'

            res.append(s[j:j + length])
            i = j + length

        return res
