class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> frequency = new HashMap<>();

       for(int n : nums) {
         frequency.merge(n, 1, Integer::sum);
       }
       
       List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

       for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
        buckets[entry.getValue()].add(entry.getKey());
       }

       int collectionIndex = 0;
       int[] results = new int[k];

       for (int i = buckets.length - 1; i >= 0; i--) {
        if(collectionIndex == k) break;
        List<Integer> bucket = buckets[i];
        if(bucket.isEmpty()) continue;

        for(int num: bucket) {
            results[collectionIndex] = num;
            collectionIndex++;
        }

       }
       return results;

    }
}
