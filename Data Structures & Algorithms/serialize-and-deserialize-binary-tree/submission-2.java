/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    // Is enncoded using ','. 
    //If value does not exist returns "null"
    public String serialize(TreeNode root) {
        if(root == null) return "null"; //This value should be null in serialization

        //Serialize left sub tree
        String left = serialize(root.left);
        //Serialize right sub tree
        String right = serialize(root.right);

        //Add values and left and right subtrees together
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //Split parts back into each separate node
        String[] parts = data.split(",");
        //Add queue for order of processing
        Deque<String> partsQue = new ArrayDeque<>();
        for(String part : parts) {
            partsQue.addLast(part);
        }
        //Call recursive helper
        return deserializeRecurse(partsQue);

     
    }

    private TreeNode deserializeRecurse(Deque<String> dataParts) {
        if(dataParts == null || dataParts.isEmpty()) return null; //Queue is finished
        String current = dataParts.pollFirst(); //Get and remove current node
        if(current == null || current.equals("null")) return null; //If node is "null", its null in treenode

        TreeNode node = new TreeNode(Integer.valueOf(current)); //Create current node with integer conversion
        TreeNode left = deserializeRecurse(dataParts); //Handle left
        TreeNode right = deserializeRecurse(dataParts); //Handle right
        //Update node pointers
        node.left = left;
        node.right = right;

        //Returns the node
        return node;
    }
}
