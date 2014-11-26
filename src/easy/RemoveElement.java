package easy;

/**
 * Created by Genustin on 11/26/2014.
 * case1 : A is empty
 * case2 : A are all elem
 * case3 : A has no elem
 * case4 : A has some elem
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) return 0;
        int i; // there should have no elem before i
        int j; // j should always be the last non-elem element
        for (i = 0, j = A.length - 1; i <= j; i++) {
            if (A[i] == elem) {
                // find non-elem
                while (j >= i && A[j] == elem)
                    j--;
                // swap or not?
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
