class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> cooldowns = new ArrayDeque<>();
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        for (int charFreq : freq) {
            if (charFreq != 0) {
                maxHeap.add(charFreq);
            }
        }

        int total = 0;
        while (!maxHeap.isEmpty() || !cooldowns.isEmpty()) {
            total++;

            if (!maxHeap.isEmpty()) {
                int maxFreq = maxHeap.poll();
                if (maxFreq-1 > 0) {
                    cooldowns.addLast(new int[] {maxFreq - 1, total + n});
                }
            }
            if(!cooldowns.isEmpty()) {
                int[] first = cooldowns.peekFirst();
                if(total >= first[1]) {
                    //we can reschedule it?
                    maxHeap.add(first[0]);
                    cooldowns.pollFirst();
                }
            }
        }

        return total;
    }
}
