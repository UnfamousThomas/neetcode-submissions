class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int b = stack.pop()
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "/" -> {
                    int b = stack.pop()
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(s));
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
