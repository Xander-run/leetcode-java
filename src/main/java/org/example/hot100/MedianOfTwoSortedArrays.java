package org.example.hot100;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int l = (len1 + len2 + 1) / 2;
        int r = (len1 + len2 + 2) / 2;
        double lValue = findKth(nums1, 0, nums2, 0, l);
        double rValue = findKth(nums1, 0, nums2, 0, r);
        return (lValue + rValue) / 2;
    }

    public static double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {

       if (start1 >= nums1.length) {
           return nums2[start2 + k - 1];
       }

       if (start2 >= nums2.length) {
           return nums1[start1 + k -1];
       }

       if (k == 1) {
           return Math.min(nums1[start1], nums2[start2]);
       }

       int midIndex1 = start1 + k/2 - 1;
       int midIndex2 = start2 + k/2 - 1;
       int midVal1 = midIndex1 >= nums1.length ? Integer.MAX_VALUE : nums1[midIndex1];
       int midVal2 = midIndex2 >= nums2.length ? Integer.MAX_VALUE : nums2[midIndex2];
       if (midVal1 < midVal2) {
           return findKth(nums1, midIndex1 + 1, nums2, start2, k - k/2);
       } else {
           return findKth(nums1, start1, nums2,midIndex2 + 1, k - k/2);
       }
    }
}
