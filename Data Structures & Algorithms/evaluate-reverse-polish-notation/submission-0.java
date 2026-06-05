class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                int result = stack.pop() + stack.pop();
                stack.push(result);
                continue;
            }
            if(s.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();

                int result = second-first;
                stack.push(result);
                continue;
            }
            if(s.equals("*")) {
                int result = stack.pop() * stack.pop();
                stack.push(result);
                continue;
            }
            if(s.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();

                int result = first / second;
                stack.push(result);
                continue;
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
