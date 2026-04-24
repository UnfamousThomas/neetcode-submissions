class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visitedNums = {}
        for index, num in enumerate(nums):
            difference = target - num
            if difference in visitedNums:
                return [visitedNums[difference], index]
            else:
                visitedNums[num] = index
        return []