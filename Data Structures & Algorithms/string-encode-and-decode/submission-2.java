class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs) {
            result.append(str.length());
            result.append('#');
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int j = i;

            while(j < str.length()) {
                char currentChar = str.charAt(j);
                if(currentChar == '#') {
                    int len = Integer.parseInt(str.substring(i,j));
                    String decoded = str.substring(j+1,j+len+1);
                    decodedStrings.add(decoded);
                    i = j + len + 1;
                    break;
                }
                j++;
            }
        }
        return decodedStrings;
    }
}
