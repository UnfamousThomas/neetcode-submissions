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
        //If root is null, we can return an empty list
        if(root == null) return new ArrayList<>();

        //Add the initial root to the queue
        processing.addFirst(root);

        //And we know we have to process the size of root (1) initially
        int toProcess = 1;

        //Store current level results
        List<Integer> currentLevel = new ArrayList<>();
        //Store final result
        List<List<Integer>>  result = new ArrayList<>();

        //Keep going until data structure has no more elements
        while(!processing.isEmpty()) {
            //If toProcess is 0, it means we have finished the level
            if(toProcess == 0) {
                toProcess = processing.size(); //Next level elements
                result.add(currentLevel); //Add the current level to the final results
                currentLevel = new ArrayList<>(); //reset current level
            }
            //Get the first element from the queue
            TreeNode node = processing.pollFirst();

            //Add child elements to the queue
            if(node.left != null) processing.addLast(node.left);
            if(node.right != null) processing.addLast(node.right);

            //Add value to the result
            currentLevel.add(node.val);

            //We have processed one
            toProcess--;
        }

        //Final is not added currently
        result.add(currentLevel);

        //Return the full result
        return result;
    }

    
}
