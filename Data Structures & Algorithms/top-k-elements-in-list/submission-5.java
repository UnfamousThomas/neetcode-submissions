class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Uses n as key, with frequency as value
        Map<Integer, Integer> frequency = new HashMap<>();
        
        //Populate frequency map
        for (int n : nums) {
            frequency.merge(n, 1, Integer::sum);
        }

        //List of buckets, max length is the length of the array
        List<Integer>[] buckets = new List[nums.length + 1];

        //Pre populate the buckets with empty lists
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        
        //For every frequency, stores the n that appears that time in a corresponding bucket
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        //Stores how many we have collected
        int collectionIndex = 0;

        //resulsts to return
        int[] results = new int[k];

        //Loop from the end
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (collectionIndex == k) //k have been collected
                break;
            List<Integer> bucket = buckets[i]; //get the corresponding bucket
            if (bucket.isEmpty()) //empty bucket, no element appeared
                continue;

            for (int num : bucket) { //This adds all elements with the same frequency to the result
                results[collectionIndex] = num;
                collectionIndex++;
            }
        }
        return results; //returns results after processing
    }
}
