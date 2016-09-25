package com.genustin.easy;

/**
 * Created by Genustin on 12/21/14.
 * <p/>
 * The count-and-say sequence is the sequence of integers beginning as follows
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p/>
 * Given an integer n, generate the nth sequence.
 * Note: the P38 always start from "1";
 */
public class P38 {
    public String countAndSay(int n) {
        String say = "1";
        String temp;
        for (int k = 1; k < n; k++) {
            temp = "";
            int i = 0;
            while (i < say.length()) {
                char ptr = say.charAt(i);
                int num = 0;
                while (i < say.length() && say.charAt(i) == ptr) {
                    i++;
                    num++;
                }
                temp = temp.concat(String.valueOf(num)).concat(String.valueOf(ptr));
            }
            say = temp;
        }
        return say;
    }

    public static void main(String[] args) {
        P38 cs = new P38();
        System.out.println(cs.countAndSay(20));
    }
}
