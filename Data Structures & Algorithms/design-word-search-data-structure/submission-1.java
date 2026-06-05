class WordDictionary {
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

    public WordDictionary() {}
    TreeNode root = new TreeNode();

    //Adding is simple, just traverse and add characters
    public void addWord(String word) {
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
        return searchHelper(root, word, 0);
    }

    //recursive search
    boolean searchHelper(TreeNode node, String word, int index) {
        if (word.length() == index) //we have reached the end of a word
            return node.end;

        char currentChar = word.charAt(index);
        if (currentChar == '.') {
            //Go through every available children character
            for (TreeNode child : node.nodes) {
                //If helper returns true, return true, starting helper from index + 1
                if (child != null && searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            //If none matched, search cannot find anything more
            return false;
        }
        //Next to process is the node with the currentChar
        TreeNode next = node.getCharacter(currentChar);
        if (next == null)
            return false;
        
        //Process next letter
        return searchHelper(next, word, index + 1);
    }
}
