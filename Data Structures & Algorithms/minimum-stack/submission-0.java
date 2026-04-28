class MinStack {
    private Deque<Integer> values = new ArrayDeque<>();
    private Deque<Integer> minimums = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        values.push(val);
        if(minimums.size() == 0) {
            minimums.push(val);
            return;
        }

        int currentMin = minimums.getFirst();
        int min = Math.min(currentMin, val);
        minimums.push(min);
    }
    
    public void pop() {
        values.pop();
        minimums.pop();
    }
    
    public int top() {
        return values.getFirst();
    }
    
    public int getMin() {
        return minimums.getFirst();
    }
}
