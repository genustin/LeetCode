package com.genustin.easy;

/**
 * Created by Genustin on 11/29/14.
 * <p/>
 * Given a non-negative number represented as an array of digits,
 * plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is
 * at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int sum;
        int addend = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + addend;
            if (sum > 9) result[i] = sum % 10;
            else result[i] = sum;
            addend = sum / 10;
        }

        if (addend > 0) {
            int[] temp = new int[result.length + 1];
            temp[0] = addend;
            for (int i = 0; i < result.length; i++) {
                temp[i + 1] = result[i];
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0};
        PlusOne po = new PlusOne();
        int[] B = po.plusOne(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
