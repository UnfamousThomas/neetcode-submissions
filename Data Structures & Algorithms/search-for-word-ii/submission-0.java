class Solution {
    class TreeNode {
        // Store the children nodes pointers
        // 26 characters, so 26 possible nodes
        TreeNode[] nodes = new TreeNode[26];

        String word;

        // Utility method for updating a character
        void setCharacter(TreeNode node, char character) {
            this.nodes[character - 'a'] = node;
        }

        // Utility method for getting a characters node in the current node
        TreeNode getCharacter(char character) {
            return this.nodes[character - 'a'];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();
        insertWords(root, words);
        List<String> results = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            //i is row
            for(int j = 0; j < board[0].length; j++) {
                //j is column
                findWords(root, i, j, board, results);
            }
        }
        return results;
    }

    private void findWords(
        TreeNode current, int row, int col, char[][] board, List<String> results) {
        if (current == null || board[row][col] == '#')
            return;
        TreeNode charNode = current.getCharacter(board[row][col]);
        if (charNode == null)
            return;
        if (charNode.word != null && !charNode.word.isEmpty()) {
            results.add(charNode.word);
            charNode.word = null;
        }

        char value = board[row][col];
        board[row][col] = '#';
        if (row + 1 < board.length) {
            // array has another row after?
            findWords(charNode, row + 1, col, board, results);
        }
        if (row > 0) {
            // array has previous row?
            findWords(charNode, row - 1, col, board, results);
        }

        if (col + 1 < board[0].length) {
            // another column
            findWords(charNode, row, col + 1, board, results);
        }
        if (col > 0) {
            // previous column
            findWords(charNode, row, col - 1, board, results);
        }
        board[row][col] = value;
    }

    private void insertWords(TreeNode root, String[] words) {
        for (String word : words) {
            TreeNode last = root;
            for (Character c : word.toCharArray()) {
                TreeNode charNode = last.getCharacter(c);
                if (charNode == null) {
                    charNode = new TreeNode();
                    last.setCharacter(charNode, c);
                }
                last = charNode;
            }
            last.word = word;
        }
    }
}
