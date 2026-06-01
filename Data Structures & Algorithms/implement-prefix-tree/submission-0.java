class PrefixTree {
    class TreeNode {
        TreeNode[] nodes = new TreeNode[26];
        boolean end = false;

        void setCharacter(TreeNode node, char character) {
            this.nodes[character - 'a'] = node;
        }

        void setEnd(boolean end) {
            this.end = end;
        }
        TreeNode getCharacter(char character) {
            return this.nodes[character - 'a'];
        }
    }
    public PrefixTree() {}
    TreeNode root = new TreeNode();

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
        current.setEnd(true);
    }

    public boolean search(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TreeNode newNode = current.getCharacter(currentChar);
            if (newNode == null)
                return false;
            current = newNode;
        }
        return current.end;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            TreeNode newNode = current.getCharacter(currentChar);
            if (newNode == null)
                return false;
            current = newNode;
        }
        return true;
    }
}
