package easy;

/**
 * Created by Genustin on 11/29/14.
 * <p/>
 * Given a sorted array, remove the duplicates in place
 * such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array,
 * you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[k]) {
                A[++k] = A[i];
            }
        }
        return k + 1;
    }
}
