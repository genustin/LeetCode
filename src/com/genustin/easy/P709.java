package com.genustin.easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase
 */
public class P709 {
  public String toLowerCase(String str) {
    char[] low = new char[str.length()];
    for(int i = 0; i < str.length(); i++) {
      low[i] = str.charAt(i);
      if(low[i] >= 'A' && low[i] <= 'Z')
        low[i] = Character.toLowerCase(low[i]);
    }
    return String.valueOf(low);
  }

  public static void main(String[] args) {
    P709 sol = new P709();
    System.out.println(sol.toLowerCase("ABCDefg5"));
  }
}
