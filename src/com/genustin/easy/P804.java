package com.genustin.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 */
public class P804 {

  private String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

  public int uniqueMorseRepresentations(String[] words) {
    Set results = new HashSet<String>();
    for (String word : words) {
      char[] carr = word.toCharArray();
      StringBuilder mcode = new StringBuilder();
      for (char x : carr) mcode.append(morse[x - 'a']);
      results.add(mcode.toString());
      System.out.println(word + " : " + mcode);
    }
    return results.size();
  }

  public static void main(String[] args) {
    P804 sol = new P804();
    String[] words = new String[]{"gin", "zen", "gig", "msg"};
    System.out.println(sol.uniqueMorseRepresentations(words));
  }
}
