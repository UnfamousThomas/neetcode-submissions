class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Here we need to use hashing to check for duplicate
        // For this we need at a total of 9+9+9 sets (9 rows, 9 columsn, 9 squares)
        // To make checks easier we store them in an array

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

        for (int i = 0; i < board.length; i++) {
            char[] currentLine = board[i];
            for (int j = 0; j < currentLine.length; j++) {
                // j represents column
                // i represents row
                char currentVal = board[i][j];
                // Empty box
                if (currentVal == '.')
                    continue;

                // Check if the current row has the value
                if (rows[i].contains(currentVal)) {
                    return false;
                }

                // Current column
                if (col[j].contains(currentVal)) {
                    return false;
                }

                // Current square
                // BY FAR, THE HARDEST PART HERE. I DONT KNOW IF I COULD COME UP WITH THIS DURING AN
                // INTERVIEW.
                int squareIndex = (i / 3) * 3 + (j / 3);
                if (square[squareIndex].contains(currentVal)) {
                    return false;
                }
                // If not, we add those values
                rows[i].add(currentVal);
                col[j].add(currentVal);
                square[squareIndex].add(currentVal);
            }
        }
        return true;
    }
}
