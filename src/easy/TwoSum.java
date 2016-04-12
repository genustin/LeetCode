package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wayne on 16/4/12.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> ele = new HashSet<>();
        int [] result = new int[2];

        for (int x : nums) {
            ele.add(x);
        }

        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if (reminder != nums[i] && ele.contains(reminder)) {
                for (int j = 0; j < nums.length; j++) {
                    if (reminder == nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
