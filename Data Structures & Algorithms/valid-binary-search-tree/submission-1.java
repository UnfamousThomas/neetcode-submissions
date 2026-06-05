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
         if (root.left != null && root.left.val > root.val)
            return false;
        if (root.right != null && root.right.val < root.val)
            return false;
        if (root.left != null && !isValidBSTHelper(root.left, root.left.val, max))
            return false;
        if (root.right != null && !isValidBSTHelper(root.right, min, root.right.val))
            return false;
        if(root.val > max || root.val < min) return false;

        return true;
    }
}
