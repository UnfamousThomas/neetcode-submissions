class Solution {
    // In reality, this is a partitioning problem
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // To avoid binary search issues, search smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int lo = 0;
        int hi = nums1.length;
        // Combined length
        int totalLength = nums1.length + nums2.length;
        while (hi >= lo) {
            // Mid here also represents the cutting place in nums1, where the element on the left
            // are smaller than on the right.
            int mid = (lo + hi) / 2;
            // Represents mid for nums2.
            int otherCut = totalLength / 2 - mid;
            // Left edge for nums1.
            int left1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            // Right edge for nums1.
            int right1 = (mid == nums1.length) ? Integer.MAX_VALUE : nums1[mid];
            // left edge for nums2.
            int left2 = (otherCut == 0) ? Integer.MIN_VALUE : nums2[otherCut - 1];
            // Right edge for nums2.
            int right2 = (otherCut == nums2.length) ? Integer.MAX_VALUE : nums2[otherCut];

            // left1 is the largest element we took from nums1's left side.
            // right2 is the smallest element on nums2's right side.
            // If left1 > right2, we put an element in the left half that's bigger
            // than something in the right half — the partition is invalid.
            // Fix: take fewer from nums1 by moving hi left.
            if (left1 > right2) {
                // We need to take less from nums1
                hi = mid - 1;
                // left2 > right1 means nums2 contributed an element to the left half
                // that's bigger than nums1's right side — also invalid.
                // Fix: take more from nums1 to compensate by moving lo right.
            } else if (left2 > right1) {
                // Take more from nums 1
                lo = mid + 1;
                // Valid partition found! Every left element <= every right element.
                // For even length: median is average of the two middle elements
                // (largest of left edges, smallest of right edges).
                // For odd length: median is the smallest element of the right half.
            } else {
                if (totalLength % 2 == 0) {
                    // even, so the calculation is complex
                    int maxLeft = Math.max(left1, left2);
                    int minRight = Math.min(right1, right2);
                    return (maxLeft + minRight) / 2d;
                } else {
                    return Math.min(right1, right2);
                }
            }
        }
        return -1;
    }
}
