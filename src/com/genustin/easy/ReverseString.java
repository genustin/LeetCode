package com.genustin.easy;

/**
 * Created by Genustin on 8/7/16.
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        int lastInx = s.length() - 1;
        char[] tmp = new char[s.length()];
        for (int i = 0; i <= lastInx - i; i++) {
            tmp[i] = s.charAt(lastInx - i);
            tmp[lastInx - i] = s.charAt(i);
        }
        return String.copyValueOf(tmp);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.reverseString("");
        rs.reverseString("1");
        rs.reverseString("1234");
        rs.reverseString("12345");
        rs.reverseString("1234567890");
    }
}
