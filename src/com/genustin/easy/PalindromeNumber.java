package com.genustin.easy;

/**
 * Created by Genustin on 12/10/14.
 * <p/>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * case 1: negative number is not considered as palindrome.
 * case 2: 1021
 * case 3: large x
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // divHigh might overflow if x is too large.
        long divHigh = 10;
        long divLow = 10;
        while (x / divHigh > 0)
            divHigh *= 10;
        while (divHigh > divLow) {
            // don't change x
            if ((x % divHigh) / (divHigh / 10) != (x % divLow) / (divLow / 10))
                return false;
            divHigh /= 10;
            divLow *= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        pn.isPalindrome(1000000001);
    }
}
