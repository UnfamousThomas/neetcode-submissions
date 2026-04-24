class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> frequency = new HashMap<>();

       for(int n : nums) {
         frequency.merge(n, 1, Integer::sum);
       }
       Queue<Map.Entry<Integer,Integer>> elements = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

       for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
        elements.add(entry);
        if(elements.size() > k) {
            elements.poll();
        }
       }

       int[] results = new int[k];
       for(int i = 0; i < k; i++) {
        int result = elements.poll().getKey();
        results[i] = result;
       }

       return results;

    }
}
