package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genustin on 11/15/14.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> line;
        if (numRows <= 0)
            return triangle;
        if (triangle.isEmpty()) {
            line = new ArrayList<Integer>();
            line.add(1);
            triangle.add(line);
        }
        for (int row = 1; row < numRows; row++) {
            line = new ArrayList<Integer>();
            line.add(1);
            for (int j = 1; j < row; j++) {
                List<Integer> aboveLine = triangle.get(row - 1);
                line.add(aboveLine.get(j - 1) + aboveLine.get(j));
            }
            line.add(1);
            triangle.add(line);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(0));
        System.out.println(pt.generate(2));
        System.out.println(pt.generate(3));
        System.out.println(pt.generate(9));
        System.out.println(pt.generate(10));
        System.out.println(pt.generate(30));
    }
}
