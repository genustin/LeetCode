package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Genustin on 4/10/16.
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        Set<Integer> counts = new HashSet<>();
        for (int x : nums) {
            counts.add(x);
        }

        if (counts.size() == nums.length) {
            return false;
        }

        return true;
    }
}
