package com.genustin.easy;

/**
 * Created by Genustin on 11/9/14.
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        String l = s.toLowerCase();
        int i = 0;
        int j = l.length() - 1;
        while (i < j) {
            if (!(Character.isLetterOrDigit(l.charAt(i)))) {
                i++;
            } else if (!(Character.isLetterOrDigit(l.charAt(j)))) {
                j--;
            } else if (l.charAt(i) == l.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "1a2";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(a));
    }

}
