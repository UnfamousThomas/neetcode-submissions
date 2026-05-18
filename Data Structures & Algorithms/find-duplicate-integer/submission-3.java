class Solution {
    //The thinking here is to consider the array a linked list
    //Where each value points to some other value
    //This results in the issue becoming a cycle detection problem
    //For this, using the slow-fast pointer algorithm is classic
    public int findDuplicate(int[] nums) {
        int slow = 0; //Slow pointer
        int fast = 0; //Fast pointer
        while (fast < nums.length) {
            slow = nums[slow]; //Set slow to equal the value, in traditional it would be node.next
            fast = nums[nums[fast]]; //Set fast to equal to the next pointer, traditionally node.next.next

            if (slow == fast) break; //If they equal, a cycle was detected
        }
        slow = 0; //Reset slow

        while(slow != fast) { //Then find the pointer in between them
            slow = nums[slow]; //Slow is pointed to the next value
            fast = nums[fast]; //Fast is pointed to the next value
        }
        return slow; //when fast and slow are equal, we found the dupe value
    }
}
