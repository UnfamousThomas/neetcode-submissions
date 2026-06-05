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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, -1001, 1001);
    }

    private boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val > max || root.val < min)
            return false;

        if (!isValidBSTHelper(root.left, min, root.val)
            || !isValidBSTHelper(root.right, root.val, max))
            return false;

        return true;
    }
}
