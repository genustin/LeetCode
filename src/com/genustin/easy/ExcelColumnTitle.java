package com.genustin.easy;

/**
 * Created by Genustin on 12/25/14.
 * <p/>
 * Given a positive integer, return its corresponding column title
 * as appear in an Excel sheet
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB
 */
public class ExcelColumnTitle {
    // think in the way of transfer decimal to hexadecimal
    // the key difference is excel column starts from 1, not 0.
    // so I would use n-1 to do the transfer, as it would start from 0.
    public String convertToTitle(int n) {
        if (n == 0) return "";
        String MAP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int size = MAP.length();
        // pre calculate the length
        long div = 0;
        long mul = 1;
        int len = 0;
        while (n > div) {
            len++;
            mul = mul * size;
            div = mul + div;
        }

        // I make the mapping starts from 0, easier to calculate.
        int num = n - 1;
        char[] output = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            output[i] = MAP.charAt(num % size);
            // make the mapping starts from 0
            num = num / size - 1;
        }
        return String.valueOf(output);
    }

    public static void main(String[] args) {
        ExcelColumnTitle ect = new ExcelColumnTitle();
        System.out.println(ect.convertToTitle(1));
        System.out.println(ect.convertToTitle(2));
        System.out.println(ect.convertToTitle(3));
        System.out.println(ect.convertToTitle(5));
        System.out.println(ect.convertToTitle(8));
        System.out.println(ect.convertToTitle(13));
        System.out.println(ect.convertToTitle(21));
        System.out.println(ect.convertToTitle(27));
        System.out.println(ect.convertToTitle(52));
        System.out.println(ect.convertToTitle(53));
        System.out.println(ect.convertToTitle(701));
        System.out.println(ect.convertToTitle(702));
        System.out.println(ect.convertToTitle(1000000001));
    }
}