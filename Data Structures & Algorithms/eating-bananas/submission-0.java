class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = findMaxPile(piles);
        while(lo < hi) {
            int midPoint = lo + (hi - lo) / 2; //Find middle speed between them
            if(canFinish(piles, midPoint, h)) {
                hi = midPoint;
            } else {
                lo = midPoint + 1;
            }
        }
        return lo;
    }
    // k is speed
    // h is hour amount
    // piles is the piles
    boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
    int findMaxPile(int[] piles) {
        int max = 0;

        for(int p : piles) {
            max = Math.max(max, p);
        }
        return max;
    }
}
