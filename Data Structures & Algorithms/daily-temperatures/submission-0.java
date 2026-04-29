class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.getFirst()] < current) {
                //warmer, update result
                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
