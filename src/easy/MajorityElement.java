package easy;

/**
 * Created by Genustin on 12/24/14.
 * <p/>
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than n/2 times
 * <p/>
 * You may assume that the array is non-empty
 * and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int x = num[0]; // record the possible majority
        int count = 1;  // record occur times of x
        // we start from num[0], count++ when meet same num, else count--
        // as there always have the majority, finally, count is more than 1
        // and the x is what we want.
        // this is "A Fast Majority Vote Algorithm"
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                x = num[i];
                count++;
            } else if (x == num[i])
                count++;
            else
                count--;
        }
        return x;
    }
}
