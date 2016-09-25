package com.genustin.easy;

/**
 * Created by Genustin on 11/26/2014.
 * case1 : A is empty
 * case2 : A are all elem
 * case3 : A has no elem
 * case4 : A has some elem
 */
public class P27 {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i; // there should have no elem before i
        int j; // j should always be the last non-elem element, move elem after j
        for (i = 0, j = A.length - 1; i <= j; i++) {
            if (A[i] == elem) {
                // find a non-elem from back for switch
                // pay attention if j reach i
                while (j >= i && A[j] == elem)
                    j--;
                // A[j] is a non-elem, swap
                if (i < j) {
                    swap(A, i, j);
                    j--;
                }
            }
        }
        return j + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
