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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //If preorder has been processed, cannot build a tree
        if(preorder.length == 0) return null;

        //Root of current sub-tree is first element in preorder
        TreeNode root = new TreeNode(preorder[0]);
        
        //Index in inorder that has the root value
        int foundIndex = 0;

        //find the index
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                foundIndex = i;
                break;
            }
        }
        //The logic here is basically that everything to the left of the index in preorder is in the left side, right side is right

        int rightSubTreeStart = foundIndex + 1;
        //Copy inorder left side
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, foundIndex);
        //Copy inorder right side
        int[] rightInOrder = Arrays.copyOfRange(inorder, rightSubTreeStart, inorder.length);
        //Copy preorder left side, besides root
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, foundIndex + 1);
        //Copy preorder right side
        int[] rightPreOrder = Arrays.copyOfRange(preorder, rightSubTreeStart, preorder.length);

        //do recursion by building the left and right side trees based on the arrays
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}
