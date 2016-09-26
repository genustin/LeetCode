package com.genustin.easy;

/**
 * Created by wayne on 16/8/16.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class P263 {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int number = num;
        while (number % 2 == 0)
            number = number >> 1;
        while (number % 3 == 0)
            number = number / 3;
        while (number % 5 == 0)
            number = number / 5;

        return number == 1;
    }

    public static void main(String[] args) {
        P263 un = new P263();
        System.out.println(un.isUgly(-1));
        System.out.println(un.isUgly(0));
        System.out.println(un.isUgly(1));
        System.out.println(un.isUgly(2));
        System.out.println(un.isUgly(3));
        System.out.println(un.isUgly(4));
        System.out.println(un.isUgly(5));
        System.out.println(un.isUgly(6));
        System.out.println(un.isUgly(7));
        System.out.println(un.isUgly(8));
        System.out.println(un.isUgly(9));
        System.out.println(un.isUgly(10));
        System.out.println(un.isUgly(11));
        System.out.println(un.isUgly(14));
        System.out.println(un.isUgly(2147483647));
    }
}
