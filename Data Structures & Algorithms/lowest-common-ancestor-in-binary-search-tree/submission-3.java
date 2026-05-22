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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) { //Since both are smaller than root, its left from root
            return lowestCommonAncestor(root.left, p, q); //Check the left side of the tree
        }
        if(root.val < p.val && root.val < q.val) { //Both are greater than root, its right from root
            return lowestCommonAncestor(root.right, p, q); //Check right side
        }
        return root; //If mix-match, only root can be the ancestor
    }
}
