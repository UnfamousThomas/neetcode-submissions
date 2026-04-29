class Solution {
    public int largestRectangleArea(int[] heights) {
        //basically, we need to SOMEHOW find the largest continous height
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        Deque<Integer> stack = new ArrayDeque<>();
        int largest = 0;
        for(int i = 0; i < h.length; i++) {
            while(!stack.isEmpty() && h[stack.getFirst()] > h[i]) {
                int heightPos = stack.pop();
                int startingPos = stack.isEmpty() ? -1 : stack.getFirst();
                int endingPos = i - 1;
                int length = endingPos - startingPos;
                largest = Math.max(largest, length*h[heightPos]);
                continue;
            }
            stack.push(i);
        }
        return largest;
    }
}
