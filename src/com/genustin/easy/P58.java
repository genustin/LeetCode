package com.genustin.easy;

/**
 * Created by Genustin on 12/7/14.
 * Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ',
 * return the length of last word in the string.
 * <p/>
 * case 1: s="", return 0;
 * case 2: s="a b", return 1;
 * case 3: s="a ", return 1;
 * case 4: s =" ", return 0;
 */
public class P58 {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        int k = s.lastIndexOf(' ');
        if (k != s.length() - 1)
            return s.length() - 1 - k;
        else
            return lengthOfLastWord(s.substring(0, s.length() - 1));
    }
}
