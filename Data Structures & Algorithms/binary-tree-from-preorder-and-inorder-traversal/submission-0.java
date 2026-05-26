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
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        
        int foundIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                foundIndex = i;
                break;
            }
        }
        int leftSubTreeEnd = foundIndex - 1;
        int rightSubTreeStart = foundIndex + 1;

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, foundIndex);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rightSubTreeStart, inorder.length);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, foundIndex + 1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, rightSubTreeStart, inorder.length);

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}
