package com.genustin.easy;

/**
 * Created by Genustin on 2/28/16.
 * <p/>
 * 2 people play 1 heap of stone, player has to take 1~3 stones each turn
 * who take the last stone is the winner,
 * start from you, would you win given n stone here?
 *
 * what if more heaps?
 */
public class P292 {
    public boolean canWinNim(int n) {
        return n % 4 > 0;
    }
}
