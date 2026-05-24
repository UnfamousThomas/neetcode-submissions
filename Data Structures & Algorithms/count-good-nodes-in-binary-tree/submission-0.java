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

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, -101);
    }
    private int goodNodesHelper(TreeNode root, int max) {
        if (root == null)
            return 0;

        int left = 0;
        int right = 0;

        // I dont think this is quite right for max
        if (root.left != null)
            left = goodNodesHelper(root.left, Math.max(max, root.val));
        if (root.right != null)
            right = goodNodesHelper(root.right, Math.max(max, root.val));

        if (root.val >= max) {
            return 1 + left + right;
        }

        return left + right;
    }
}
