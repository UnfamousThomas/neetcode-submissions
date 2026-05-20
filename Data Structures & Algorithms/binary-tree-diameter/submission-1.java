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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] currentMax = new int[]{0}; //Acts as a "global" variable

        diameterOfBinaryTreeHelper(root, currentMax); //Does the actual calculations
        return currentMax[0]; //The final result
    }

    int diameterOfBinaryTreeHelper(TreeNode node, int[] currentMax) {
        if(node == null) return 0; //Returns 0 if no node since null cannot have diameter

        int left = diameterOfBinaryTreeHelper(node.left, currentMax); //Recursively gets left
        int right = diameterOfBinaryTreeHelper(node.right, currentMax); //Recursively gets right
        currentMax[0] = Math.max(currentMax[0], left + right); //Updates current if needed

        return 1 + Math.max(left, right); //Returns larger diameter + 1 (1 being connection between left or right and this node)
    }
}
