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
    //At it's core, this is about keeping track of the max
    //Since every other element is smaller, we just need to know
    //if current nodes value is smaller than previously visited maximum
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, -101); //Start with minimum value so root is valid
    }
    private int goodNodesHelper(TreeNode root, int max) {
        if (root == null)
            return 0; //Does not count

        int left = 0;
        int right = 0;

        if (root.left != null)
            left = goodNodesHelper(root.left, Math.max(max, root.val)); //Update max if current is larger
        if (root.right != null)
            right = goodNodesHelper(root.right, Math.max(max, root.val)); //Update max if current is larger

        if (root.val >= max) {
            return 1 + left + right; //If current value equal to or larger than max it is valid
        }

        return left + right; //otherwise return from left and right branches
    }
}
