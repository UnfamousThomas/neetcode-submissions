class Solution {
    public int longestConsecutive(int[] nums) {
        int longestCount = 0;
        Set<Integer> numbers = new HashSet<>();
        for(int n : nums) {
            numbers.add(n);
        }

        for(int n : numbers) {
            if(numbers.contains(n-1)) {
                continue;
            }
            int currentCount = 1;
            while(true) {
                int lastNumber = n+currentCount-1;
                if(!numbers.contains(lastNumber+1)){
                    longestCount = Math.max(longestCount, currentCount);
                    break;
                } 
                currentCount++;
            } 
        }
        
        return longestCount;
    }
}
