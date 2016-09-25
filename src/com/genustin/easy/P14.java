package com.genustin.easy;

/**
 * Created by Genustin on 12/21/14.
 * <p/>
 * find the longest common prefix string amongst an array of strings
 */
public class P14 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs)
            return "";
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String comm = common(strs[0], strs[1]);
        for (int i = 2; i < strs.length && comm.length() > 0; i++)
            comm = common(comm, strs[i]);

        return comm;
    }

    /*
    find two strings' common prefix
     */
    private String common(String str1, String str2) {
        int i = 0;
        int len = str1.length() < str2.length() ? str1.length() : str2.length();
        while (i < len && str1.charAt(i) == str2.charAt(i))
            i++;
        return i > 0 ? str1.substring(0, i) : "";
    }
}