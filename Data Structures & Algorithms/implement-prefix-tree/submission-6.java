class PrefixTree {
    class TreeNode {
        // Store the children nodes pointers
        // 26 characters, so 26 possible nodes
        TreeNode[] nodes = new TreeNode[26];

        // Whether or not this node is the end of a word. This is for checking if a specific word,
        // not a prefix exists
        boolean end = false;

        // Utility method for updating a character
        void setCharacter(TreeNode node, char character) {
            this.nodes[character - 'a'] = node;
        }

        // Utility method for getting a characters node in the current node
        TreeNode getCharacter(char character) {
            return this.nodes[character - 'a'];
        }
    }
    public PrefixTree() {}
    // Root to store things under and search under
    TreeNode root = new TreeNode();

    // Inserts a new word into the tree
    public void insert(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TreeNode newNode = current.getCharacter(currentChar);
            if (newNode == null) {
                newNode = new TreeNode();
                current.setCharacter(newNode, currentChar);
            }

            current = newNode;
        }
        // Mark the last character as the end of a word
        current.end = true;
    }

    public boolean search(String word) {
        TreeNode current = traverse(word);
        if (current == null)
            return false;
        // Only if the last character is the end of a word
        return current.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = traverse(prefix);
        if (current == null)
            return false;
        return true;
    }

    // Utility method to traverse the tree based on a string, returns the last node
    private TreeNode traverse(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TreeNode newNode = current.getCharacter(currentChar);
            if (newNode == null)
                return null;
            current = newNode;
        }
        return current;
    }
}
