class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int minPrice = prices[0];

        for(int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];

            maximumProfit = Math.max(maximumProfit, currentPrice - minPrice);
            minPrice = Math.min(minPrice, currentPrice);
        }
        return maximumProfit;
    }
}
