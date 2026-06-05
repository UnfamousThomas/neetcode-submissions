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
        boolean[] balanced = new boolean[]{true};
        treeHeight(root, balanced);


        return balanced[0];
    }

    public int treeHeight(TreeNode root, boolean[] balanced) {
        if(root == null) return 0;
        int left = treeHeight(root.left, balanced);
        int right = treeHeight(root.right, balanced);
        if(left-1 >right || right-1 > left) {
            balanced[0] = false;
            return 1; //no longer important
        }
        return 1 + left + right;
    }
}
