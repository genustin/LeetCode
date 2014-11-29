package easy;

/**
 * Created by Genustin on 11/29/14.
 * <p/>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 */
public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int len = m;
        int ptrA = 0;
        int ptrB;
        // insert ptrB into ptrA
        for (ptrB = 0; ptrA < len && ptrB < n; ptrB++) {
            //find a suitable position
            ptrA = binSearch(A, ptrA, len - 1, B[ptrB]);
            // move the elements to the end
            move(A, ptrA, len);
            A[ptrA] = B[ptrB];
            ptrA++;
            len++;
        }

        // all the element left in B is bigger than A
        // then concatenate B to A
        if (ptrA == len) {
            while (ptrB < n) {
                A[ptrA++] = B[ptrB++];
            }
        }
    }

    public int binSearch(int[] A, int begin, int end, int elem) {
        if (begin == end) {
            if (elem <= A[begin]) {
                return begin;
            } else {
                return end + 1;
            }
        }
        int mid = (begin + end) / 2;
        if (elem < A[mid])
            return binSearch(A, begin, mid, elem);
        else if (elem > A[mid])
            return binSearch(A, mid + 1, end, elem);
        else
            return mid;
    }

    private void move(int[] A, int begin, int end) {
        for (int i = end; i > begin; i--) {
            A[i] = A[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] B = {2, 4};
        int n = B.length;
        int[] A = new int[5];
        A[0] = 1;
        A[1] = 1;
        A[2] = 10;
        int m = 3;
        MergeSortedArray msa = new MergeSortedArray();
//        System.out.println(msa.binSearch(A, 0, 2, 7));
        msa.merge(A, m, B, n);
        for (int i = 0; i < m + n; i++) {
            System.out.println(A[i]);
        }
    }
}
