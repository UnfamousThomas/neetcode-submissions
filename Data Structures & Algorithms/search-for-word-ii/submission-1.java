class Solution {
    class TreeNode {
        // Store the children nodes pointers
        // 26 characters, so 26 possible nodes
        TreeNode[] nodes = new TreeNode[26];

        // If this note denotes the end of the word, store the word
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
        // Utility root element
        TreeNode root = new TreeNode();

        // Load all words into trie
        insertWords(root, words);
        List<String> results = new ArrayList<>();

        // Loop through every letter
        for (int i = 0; i < board.length; i++) {
            // i is row
            for (int j = 0; j < board[0].length; j++) {
                // j is column
                findWords(root, i, j, board, results);
            }
        }
        return results;
    }

    private void findWords(
        TreeNode current, int row, int col, char[][] board, List<String> results) {
        // Visited or something went wrong
        if (current == null || board[row][col] == '#')
            return;

        // Gets the current from trie
        TreeNode charNode = current.getCharacter(board[row][col]);
        if (charNode == null) // This letter does not continue a word
            return;

        // This letter is the end of a word
        if (charNode.word != null && !charNode.word.isEmpty()) {
            results.add(charNode.word);
            charNode.word = null; // To avoid duplicates
        }

        char value = board[row][col]; // Store the current value temporarily
        board[row][col] = '#'; // Since each node can be visited once for one word, set current
                               // value to '#' to denote visited
        if (row + 1 < board.length) {
            // array has another row after?
            findWords(charNode, row + 1, col, board, results); // right visit
        }
        if (row > 0) {
            // array has previous row?
            findWords(charNode, row - 1, col, board, results); // left visit
        }

        if (col + 1 < board[0].length) {
            // another column
            findWords(charNode, row, col + 1, board, results); // right visit
        }
        if (col > 0) {
            // previous column
            findWords(charNode, row, col - 1, board, results); // left visit
        }
        board[row][col] = value; // restore value
    }

    // Construct a trie based on all possible words
    private void insertWords(TreeNode root, String[] words) {
        for (String word : words) {
            TreeNode last = root;
            for (Character c : word.toCharArray()) {
                TreeNode charNode = last.getCharacter(c);
                if (charNode == null) {
                    charNode = new TreeNode();
                    last.setCharacter(charNode, c); // set character to new node
                }
                last = charNode; // Update the last variable for next iteration
            }
            last.word = word; // word store
        }
    }
}
