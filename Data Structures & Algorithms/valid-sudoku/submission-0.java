class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
        }
        HashSet<Character>[] col = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<>();
        }
        HashSet<Character>[] square = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            square[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++) {
            char[] currentLine = board[i];
            for(int j = 0; j < currentLine.length; j++) {
                //j represents column
                //i represents row
                char currentVal = board[i][j];
                if(currentVal == '.') continue;
                int squareIndex = (i / 3) * 3 + (j / 3);
                if(rows[i].contains(currentVal)) {
                    return false;
                }
                if(col[i].contains(currentVal)) {
                    return false;
                }
                if(square[squareIndex].contains(currentVal)) {
                    return false;
                }
                rows[i].add(currentVal);
                col[i].add(currentVal);
                square[squareIndex].add(currentVal);
            }
        }
        return true;
    }
}
