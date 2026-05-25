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
    public int kthSmallest(TreeNode root, int k) {
        //need to somehow do in-order traversal
        //go as deep down, then vist left el, node, right el. Then go up.
        int[] visited = new int[]{0};
        int[] result = new int[]{-1};
        kthSmallestHelper(root, k, visited, result);
        return result[0];
    }
    void kthSmallestHelper(TreeNode node, int k, int[] visited, int[] result) {
        if(node == null) return;
        //go left
        if(node.left != null) kthSmallestHelper(node.left, k, visited, result);
        visited[0]++;
        if(visited[0] == k) {
            result[0] = node.val;
        }
        //go right
        if(node.right != null) kthSmallestHelper(node.right, k, visited, result);

    }
}
