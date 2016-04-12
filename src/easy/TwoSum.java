package easy;

import java.util.*;

/**
 * Created by wayne on 16/4/12.
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 */
public class TwoSum {
    public int[] twoSumSet(int[] nums, int target) {
        Set<Integer> ele = new HashSet<>();
        int[] result = new int[2];

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

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> vk = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            // try to find it earily
            if (vk.containsKey(reminder) && vk.get(reminder) != i) {
                result[0] = vk.get(reminder);
                result[1] = i;
                break;
            }
            vk.put(nums[i], i); // will replace the index if there is some number
        }

        return result;
    }

    // faster
    public int[] twoSumSort(int[] nums, int target) {
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        //Quicksort.
        Arrays.sort(numsSorted);

        //Find the two numbers. O(n)
        int start = 0;
        int end = numsSorted.length;
        while (start < end) {
            while (numsSorted[start] + numsSorted[--end] > target) ;
            if (numsSorted[end] + numsSorted[start] == target)
                break;
            while (numsSorted[++start] + numsSorted[end] < target) ;
            if (numsSorted[end] + numsSorted[start] == target)
                break;
        }

        //find the indices of the two numbers
        int[] ret = new int[2];
        int index = 0;
        int a = numsSorted[start];
        int b = numsSorted[end];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == a || nums[i] == b)
                ret[index++] = i;
        return ret;
    }

    // fastest
    public int[] twoSum(int[] nums, int target) {
        // Since x1 + x2 = target, we can in one loop
        // mark both x1 and x2 in some additional array where we'll keep indices
        // Though to build that array we'd need another loop

        int min = nums[0], max = min;
        // first loop to find max and min integers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        // valid range for input integers relative to target
        int sMin = Math.max(min, target - max);
        int sMax = Math.min(max, target - min);

        // array to keep indices of valid input integers
        // initialize with -1
        int size = 1 + sMax - sMin;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = -1;

        // second loop
        for (int i = 0; i < nums.length; i++) {
            // Skip if integer is not from a valid range
            if (nums[i] > sMax || nums[i] < sMin)
                continue;
            // if found valid X1 and corresponding element of indices array is still -1
            // then mark its pair X2 = target - X1 with index of X1
            if (arr[nums[i] - sMin] == -1)
                arr[target - nums[i] - sMin] = i;
            else
                return new int[]{arr[nums[i] - sMin], i};
        }

        return new int[]{0, 0};
    }
}
