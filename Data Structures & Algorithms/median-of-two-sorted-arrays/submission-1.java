class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int lo = 0;
        int hi = nums1.length;
        int totalLength = nums1.length + nums2.length;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            int otherCut = totalLength / 2 - mid;
            int left1 = (mid == 0) ? Integer.MIN_VALUE: nums1[mid - 1];
            int right1 = (mid == nums1.length) ? Integer.MAX_VALUE : nums1[mid];
            int left2 = (otherCut == 0) ? Integer.MIN_VALUE : nums2[otherCut - 1];
            int right2 = (otherCut == nums2.length) ? Integer.MAX_VALUE : nums2[otherCut];

            if(left1 > right2) {
                //The left side is bigger than right on the other array.
                lo = mid + 1;
            } else if(left2 > right1) {
                hi = mid - 1;
            } else {
                if(totalLength % 2 == 0) {
                    //even
                    int maxLeft = Math.max(left1, left2);
                    int minRight = Math.min(right1,right2);
                    return (maxLeft + minRight) / 2d;
                } else {
                    //odd
                    return Math.min(right1, right2);
                }
            }
            
        }
        return -1;
    }
}
