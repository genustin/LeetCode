package com.genustin.hard;

/**
 * Created by wayne on 16/4/21.
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = (m + n) / 2 + 1;
        int[] nums = new int[len];
        int i = 0, j = 0, k = 0;
        while (k < len && i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        if (i >= m) {
            while (k < len) {
                nums[k++] = nums2[j++];
            }
        } else if (j >= n) {
            while (k < len) {
                nums[k++] = nums1[i++];
            }
        }

        if ((m + n) % 2 == 0) {
            return (nums[len - 2] + nums[len - 1]) / 2.0;
        } else {
            return nums[len - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4};
        P4 medianOfTwoSortedArray = new P4();
        System.out.println(medianOfTwoSortedArray.findMedianSortedArrays(nums1, nums2));
    }

}
