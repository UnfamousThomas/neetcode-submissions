class Solution {
    public boolean isValid(String s) {
       Deque<Character> parans = new ArrayDeque<>();
    
       for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == '(') {
            parans.addFirst(')');
            continue;
        }
        if(c == '[') {
            parans.addFirst(']');
            continue;
        }
        if(c == '{') {
            parans.addFirst('}');
            continue;
        }
        
        //current first needs to equal
        if(parans.removeFirst() != c) {
            return false;
        }
       }

       return parans.isEmpty(); 
    }
}
