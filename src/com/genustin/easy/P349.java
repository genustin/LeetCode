package com.genustin.easy;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Genustin on 8/19/16.
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hello = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        for (int i = 0; i < nums1.length; i++) {
            hello.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hello.contains(nums2[i]) && !inter.contains(nums2[i]))
                inter.add(nums2[i]);
        }
        int[] sol = new int[inter.size()];
        Iterator<Integer> x = inter.iterator();
        int i = 0;
        while (x.hasNext())
            sol[i++] = x.next();
        return sol;
    }


}
