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
    public String serialize(TreeNode root) {
        if(root == null) return "null";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        Deque<String> partsQue = new ArrayDeque<>();
        for(String part : parts) {
            partsQue.addLast(part);
        }
        return deserializeRecurse(partsQue);

     
    }

    private TreeNode deserializeRecurse(Deque<String> dataParts) {
        if(dataParts == null || dataParts.isEmpty()) return null;
        String current = dataParts.pollFirst();
        if(current == null || current.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(current));
        TreeNode left = deserializeRecurse(dataParts);
        TreeNode right = deserializeRecurse(dataParts);
        node.left = left;
        node.right = right;
        return node;
    }
}
