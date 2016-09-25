package com.genustin.easy;

/**
 * Created by Genustin on 8/7/16.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class P371 {
    /**
     * bit operation,
     * a & b, identify 1 vs 1 cases, which will be the carry
     * a ^ b, identify 1 vs 0 cases, which will be the residue
     * note the number is saved as 补码
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        // carry bits
        int carry = (a & b) << 1;
        // residue bits
        int residue = a ^ b;
        System.out.println("carry:" + carry);
        System.out.println("residue:" + residue);

        // note the sign number
        if (carry != 0) {
            return getSum(carry, residue);
        }

        return residue;
    }

    public static void main(String[] args) {
        P371 sti = new P371();
        int z = sti.getSum(5, -1);
        System.out.println(z);
    }
}
