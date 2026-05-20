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
        int[] currentMax = new int[]{0};

        diameterOfBinaryTreeHelper(root, currentMax);
        return currentMax[0];
    }

    int diameterOfBinaryTreeHelper(TreeNode node, int[] currentMax) {
        if(node == null) return 0;

        int left = diameterOfBinaryTreeHelper(node.left, currentMax);
        int right = diameterOfBinaryTreeHelper(node.right, currentMax);
        currentMax[0] = Math.max(currentMax[0], left + right);

        return 1 + Math.max(left, right);
    }
}
