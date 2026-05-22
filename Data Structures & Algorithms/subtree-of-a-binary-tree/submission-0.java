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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null) return false;

        if(isSameTree(root, subRoot)) {
            return true;
        } 
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; //If neither side exists, they are equal
        if(p == null || q == null) return false; //If only one side exists, they cannot be equal

        //Now, we do recursion. For the two sides to be equal:
        // 1. p.left and q.left need to be the same
        // 2. p.right and q.right need to be the same
        // 3. the local nodes values need to be equal, that is p.val and q.val
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val; 
    }
}
