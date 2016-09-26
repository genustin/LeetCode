package com.genustin.easy;

/**
 * Created by wayne on 16/2/29.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * https://en.wikipedia.org/wiki/Digital_root
 */
public class P258 {
    public int addDigits(int num) {
        int dr = num;
        while (dr > 9)
            dr = dr - ((dr - 1) / 9) * 9;
        return dr;
    }

    public static void main(String[] args) {
        P258 ad = new P258();
        System.out.println(ad.addDigits(11));
        System.out.println(ad.addDigits(12));
        System.out.println(ad.addDigits(38));
        System.out.println(ad.addDigits(1853));
        System.out.println(ad.addDigits(65535));
    }
}

