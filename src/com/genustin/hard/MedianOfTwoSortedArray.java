package com.genustin.hard;

/**
 * Created by wayne on 16/4/21.
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] nums = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        if (i >= m) {
            while (j < n) {
                nums[k++] = nums2[j++];
            }
        } else if (j >= n) {
            while (i < m) {
                nums[k++] = nums1[i++];
            }
        }

        if (len % 2 == 0) {
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        } else {
            return nums[(len) / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        System.out.println(medianOfTwoSortedArray.findMedianSortedArrays(nums1, nums2));
    }

}
