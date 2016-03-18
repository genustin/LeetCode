package easy;

/**
 * Created by wayne on 16/3/17.
 * <p/>
 * Given an array nums,
 * write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeros {
    //
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int k = 0; // count zeros
        int len = nums.length;
        for (int i = 0; i + k < len; i++) {
            while (i + k < len && nums[i + k] == 0) k++;
            if (i + k == len)
                return;
            if (k > 0) {
                nums[i] = nums[i + k];
                nums[i + k] = 0;
            }
        }
    }

    // faster
    public void moveZero(int[] nums) {
        if (nums == null || nums.length == 0) return; // define len=nums.length is slower, why?

        int k = 0; // zero index
        for (int i = 0; i < nums.length; i++) { // for (int num : nums) is slower, why?
            if (nums[i] != 0) nums[k++] = nums[i];
        }

        while (k < nums.length) {
            nums[k] = 0;   // nums[k++] is slower, why?
            k++;
        }
    }
}
