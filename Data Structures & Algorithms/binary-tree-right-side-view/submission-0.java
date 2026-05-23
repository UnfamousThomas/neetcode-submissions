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
    public List<Integer> rightSideView(TreeNode root) {
        // so... basically... this is similar to the previous
        // We want to check that no values are to the right.
        // The easiest way for that, is to again use something like a deque. Process from left to
        // right, adding
        //  to first. The last first can be seen.
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> processing = new ArrayDeque<>();
        int lastVal = root.val;

        int toProcess = 1;
        processing.addLast(root);
        while (!processing.isEmpty()) {
            if (toProcess == 0) {
                toProcess = processing.size();
                result.add(lastVal); // Add the current level to the final results
            }
            // Get the first element from the queue
            TreeNode node = processing.pollFirst();

            // Add child elements to the queue
            if (node != null && node.left != null)
                processing.addLast(node.left);
            if (node != null && node.right != null)
                processing.addLast(node.right);

            // Add value to the result
            if(node != null) lastVal = node.val;

            // We have processed one
            toProcess--;
        }
        result.add(lastVal);

        return result;
    }
}
