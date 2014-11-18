package medium;

/**
 * Created by Genustin on 11/16/14.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x = A[0];
        for (int i = 1; i < A.length; i++) {
            x = x ^ A[i];
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(1 ^ 4 ^ 1);
    }
}
