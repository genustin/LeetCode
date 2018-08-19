package com.genustin.easy;

/**
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.
 * <p>
 * Each character in S is a type of stone you have.
 * <p>
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class P771 {

  public int numJewelsInStones(String J, String S) {
    int count = 0;
    char[] jewels= J.toCharArray();
    char[] stones = S.toCharArray();
    for (int i = 0; i < S.length(); i++) {
      for (int j = 0; j < J.length(); j++) {
        if (stones[i] == jewels[j]) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    P771 sol = new P771();
    System.out.println(sol.numJewelsInStones("aH", "aHHcdssdf"));

  }
}
