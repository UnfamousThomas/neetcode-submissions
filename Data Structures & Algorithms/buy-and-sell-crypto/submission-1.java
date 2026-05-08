class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right =1;
        int maxP = 0;

        while(right < prices.length) {
            int leftPrice = prices[left];
            int rightPrice = prices[right];

            if(leftPrice >= rightPrice) {
                left = right;
            } else {
                maxP = Math.max(maxP, rightPrice - leftPrice);
            }
            right++;
        }
        return maxP;
    }
}
