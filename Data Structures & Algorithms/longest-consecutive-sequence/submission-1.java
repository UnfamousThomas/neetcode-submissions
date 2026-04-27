class Solution {
    public int longestConsecutive(int[] nums) {
        int longestCount = 0; //The biggest sequence we have found
        Set<Integer> numbers = new HashSet<>();
        for(int n : nums) { //Add all elements to a hashset
            numbers.add(n); 
        }

        for(int n : numbers) { //Vist every element
            if(numbers.contains(n-1)) { //If it contains previous, it cannot be the start, so skip
                continue;
            }
            int currentCount = 1; //We have a start, so 1
            while(true) { //Visit other element in order of increases
                int lastNumber = n+currentCount-1;
                if(!numbers.contains(lastNumber+1)){ //If no longer contains next, sequence over
                    longestCount = Math.max(longestCount, currentCount); //Update longest if needed
                    break;
                } 
                currentCount++; //Otherwise, increase count
            } 
        }
        
        return longestCount;
    }
}
