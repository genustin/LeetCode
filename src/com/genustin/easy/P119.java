package com.genustin.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genustin on 11/9/14.
 */
public class P119 {
    /*
     * (n, k) == n!/(n-k)!/k!
     *        == n!/(n-k+1)!/(k-1)! * (n - k + 1) / k
     *        == (n, k-1) * (n - k + 1) / k
     * This method is possible to overflow when do multiply.
     */
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> pascal = new ArrayList<Integer>();
//        pascal.add(1);
//        for (int i = 1; i <= rowIndex / 2; i++)
//            pascal.add(pascal.get(i - 1) * (rowIndex - i + 1) / i);
//        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++)
//            pascal.add(pascal.get(rowIndex - i));
//        return pascal;
//    }

    /*
     * compute row by row
     * 1 1
     * 1 2 1
     * 1 3 3  1
     * 1 4 6  4  1
     * 1 5 10 10 5 1
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal = new ArrayList<Integer>();
        pascal.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            int aboveLeft = pascal.get(0);
            for (int i = 1; i < row; i++) {
                int above = pascal.get(i);
                pascal.set(i, aboveLeft + above);
                aboveLeft = above;
            }
            pascal.add(1);
        }
        return pascal;
    }


    public static void main(String[] args) {
        P119 pascal = new P119();

        System.out.println(pascal.getRow(10));

    }
}
