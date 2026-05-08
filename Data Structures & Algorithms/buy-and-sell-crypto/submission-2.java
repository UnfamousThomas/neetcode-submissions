class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        // Store the maximum profit encountered
        int maxP = 0;

        //Since we move right ++ every iteration, make sure we stay in bounds
        while(right < prices.length) {
            int leftPrice = prices[left];
            int rightPrice = prices[right];

            if(leftPrice >= rightPrice) { //If left price is bigger than right price (That is, buy price is higher than sell)
                left = right; //Move left pointer to the same place as right pointer, this is because we have looked through
                //every value in the window, and no value between the current left and right was smaller than left
                //If a new value is smaller price wise, it means that should be used for price calculations now
            } else {
                maxP = Math.max(maxP, rightPrice - leftPrice); //Calculate and if needed save new max
            }
            right++; //Move right as needed
        }
        return maxP;
    }
}
