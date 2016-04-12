package com.genustin.easy;

/**
 * Created by Genustin on 12/25/14.
 * <p/>
 * The string "PAYPALISHIRING" is written in a zigzag pattern
 * on a given number of rows like this:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZag {
    public String convert(String s, int nRows) {
        if (nRows == 0) return "";
        if (nRows == 1) return s;
        int gap = 2 * nRows - 2;
        // save the output string
        char[] out = new char[s.length()];
        int k = 0;
        // first row
        for (int i = 0; i < s.length(); i += gap) {
            out[k++] = s.charAt(i);
        }

        // middle rows
        for (int i = 1; i < nRows - 1; i++) {
            for (int j = 0; j < s.length(); j += gap) {
                if (j + i < s.length())
                    out[k++] = s.charAt(j + i);
                if (j + gap - i < s.length())
                    out[k++] = s.charAt(j + gap - i);
            }
        }

        // last row
        for (int i = nRows - 1; i < s.length(); i += gap) {
            out[k++] = s.charAt(i);
        }
        return String.valueOf(out);
    }

    public static void main(String[] args) {
        ZigZag zz = new ZigZag();
        System.out.println(zz.convert("PAYPALISHIRING", 0));
        System.out.println(zz.convert("PAYPALISHIRING", 1));
        System.out.println(zz.convert("PAYPALISHIRING", 2));
        System.out.println(zz.convert("PAYPALISHIRING", 3));
        System.out.println(zz.convert("PAYPALISHIRING", 4));
        System.out.println(zz.convert("PAYPALISHIRING", 5));
        System.out.println(zz.convert("PAYPALISHIRING", 6));
        System.out.println(zz.convert("PAYPALISHIRING", 7));
        System.out.println(zz.convert("PAYPALISHIRING", 8));
    }
}
