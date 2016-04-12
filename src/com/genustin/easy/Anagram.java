package com.genustin.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Genustin on 4/10/16.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (Character x : s.toCharArray()) {
            int v = count.containsKey(x)? count.get(x) : 0;
            count.put(x, v + 1);
        }

        for (Character x : t.toCharArray()) {
            int v = count.containsKey(x)? count.get(x) : 0;
            count.put(x, v - 1);
        }

        for (Integer v : count.values()) {
            if (v != 0) return false;
        }

        return true;
    }
}
