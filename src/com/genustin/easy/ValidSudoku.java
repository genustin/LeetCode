package com.genustin.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Genustin on 12/13/14.
 * <p/>
 * Determine if a Sudoku is valid.
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 */
public class ValidSudoku {

    /**
     * 
     * @param board 9*9 Sodoku
     * @return whether it's a valid Soduku
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, HashSet<String>> map = new
                HashMap<Character, HashSet<String>>();
        HashSet<String> positions;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j]) {
                    positions = map.get(board[i][j]);
                    if (null == positions) {
                        positions = new HashSet<String>();
                        map.put(board[i][j], positions);
                    }
                    if (isConflictPos(positions, i, j))
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Split the 9*9 blocks in to 9 sections, [A-I]
     *
     * @param x row number
     * @param y column number
     * @return section id
     */
    private String getArea(int x, int y) {
        if (x < 3) {
            if (y < 3)
                return "A";
            else if (y > 5)
                return "B";
            else
                return "C";
        } else if (x > 5) {
            if (y < 3)
                return "G";
            else if (y > 5)
                return "H";
            else
                return "I";
        } else {
            if (y < 3)
                return "D";
            else if (y > 5)
                return "E";
            else
                return "F";
        }
    }

    /**
     * @param positions contains all the position of a number
     * @param i         row number
     * @param j         column number
     * @return whether new (i,j) is conflict with any saved positions
     */
    private boolean isConflictPos(HashSet<String> positions, int i, int j) {
        // column number is marked as [a-i]
        String[] rename = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        if (positions.contains(String.valueOf(i)))
            return true;
        else if (positions.contains(rename[j]))
            return true;
        else if (positions.contains(getArea(i, j)))
            return true;
        else {
            positions.add(String.valueOf(i));
            positions.add(rename[j]);
            positions.add(getArea(i, j));
            return false;
        }
    }
}
