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
    public boolean isBalanced(TreeNode root) {
        boolean[] balanced = new boolean[]{true}; //setup array to use as a pointer value to change
        treeHeight(root, balanced); //call helper recursive func


        return balanced[0]; //return the final balanced value
    }

    public int treeHeight(TreeNode root, boolean[] balanced) {
        if(root == null) return 0; //no height
        int left = treeHeight(root.left, balanced); //Calculate left height and check balancing
        int right = treeHeight(root.right, balanced); //Calculate right height and check balancing
        if(Math.abs(left-right) > 1) { //If difference is larger than 1, it is not balanced
            balanced[0] = false; //update value
            return 1; //no longer important, just retunn quick
        }
        return 1 + Math.max(left, right); //Add 1 to height
    }
}
