package com.genustin.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wayne on 16/4/20.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        int strSize = 0;
        int size = 1, begin = 0;
        for (int ptr = begin + 1, dupPtr = -1; ptr < s.length(); ptr++) {
            dupPtr = s.substring(begin, ptr).indexOf(s.charAt(ptr));
            if (dupPtr == -1) {
                size++;
            } else {
                if (size > strSize) {
                    strSize = size;
                }
                begin = begin + dupPtr + 1;
                size = ptr - begin + 1;
            }
        }
        if (size > strSize) {
            strSize = size;
        }
        return strSize;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int size = longestSubstring.lengthOfLongestSubstring("dvdf");
        size = longestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(size);

    }
}
