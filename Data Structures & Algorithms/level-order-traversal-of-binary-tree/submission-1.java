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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //basically need to return a list of levels, where each level has all the values at that level
        //for this we want a FIFO data structure
        Deque<TreeNode> processing = new ArrayDeque<>();
        if(root == null) return new ArrayList<>();
        processing.addFirst(root);
        int toProcess = processing.size();
        List<Integer> currentLevel = new ArrayList<>();
        List<List<Integer>>  result = new ArrayList<>();

        while(!processing.isEmpty()) {
            if(toProcess == 0) {
                toProcess = processing.size();
                result.add(currentLevel);
                currentLevel = new ArrayList<>();
            }
            TreeNode node = processing.pollFirst();
            if(node.left != null) processing.addLast(node.left);
            if(node.right != null) processing.addLast(node.right);

            currentLevel.add(node.val);
            toProcess--;
        }
        result.add(currentLevel);
        return result;
    }

    
}
