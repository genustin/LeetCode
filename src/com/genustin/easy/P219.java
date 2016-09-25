package com.genustin.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Genustin on 4/10/16.
 * <p>
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 */
public class P219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) return false;
        Map<Integer, Integer> countsWithIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countsWithIdx.containsKey(nums[i])) {
                if (i - countsWithIdx.get(nums[i]) <= k)
                    return true;
            }
            countsWithIdx.put(nums[i], i);
        }
        return false;
    }
}
