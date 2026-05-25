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

        //Tracker for how many nodes have been visited
        int[] visited = new int[]{0};

        //Tracker for the kth nodes value
        int[] result = new int[]{-1};

        //Call helper function that handles recursion
        kthSmallestHelper(root, k, visited, result);

        //Return result
        return result[0];
    }
    void kthSmallestHelper(TreeNode node, int k, int[] visited, int[] result) {
        if(node == null) return;
        //go left
        if(node.left != null) kthSmallestHelper(node.left, k, visited, result);

        //Increase visited and check if current node is kth
        visited[0]++;
        if(visited[0] == k) {
            result[0] = node.val;
            return;
        }
        //go right
        if(node.right != null) kthSmallestHelper(node.right, k, visited, result);

    }
}
