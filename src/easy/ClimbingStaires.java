package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Genustin on 11/24/14.
 * <p/>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p/>
 * Dynamic programming
 * d(1) = {1}
 * d(2) = {11, 2}
 * d(3) = {111, 12, 21}
 * d(4) = {1111, 112, 121, 211, 22}
 * d(i) = {d(i-1)+"1", "1"+d(i-1), "2"+d(i-2), d(i-2)+"2"}
 * there are duplicate among these sets, so it's a fibonacci polynomial
 */
public class ClimbingStaires {

    public int climbStairs(int n) {
        Map<Integer, Integer> fibo = new HashMap<Integer, Integer>();

        fibo.put(0, 1);
        fibo.put(1, 1);
        for (int i = 2; i <= n; i++) {
            fibo.put(i, fibo.get(i-1) + fibo.get(i-2));
        }
        return fibo.get(n);
    }

    /*
     * below method is very slow
     */
    public int climbStairs2(int n) {
        if (n < 3)
            return n;
        else {
            // this set is used as d(i-2)
            Set<String> m2Set = new HashSet<String>() {
                {
                    add("1");
                }
            };

            // this set is used as d(i-1)
            Set<String> m1Set = new HashSet<String>() {
                {
                    add("11");
                    add("2");
                }
            };

            // this set is used as d(i)
            Set<String> thisSet = new HashSet<String>();
            for (int i = 3; i <= n; i++) {
                thisSet.clear();
                for (String x : m2Set) {
                    thisSet.add(x + "2");
                    thisSet.add("2" + x);
                }
                for (String x: m1Set) {
                    thisSet.add(x + "1");
                    thisSet.add("1" + x);
                }
                m2Set = new HashSet<String>(m1Set);
                m1Set = new HashSet<String>(thisSet);
            }

            return thisSet.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStaires().climbStairs(40));
        System.out.println(new ClimbingStaires().climbStairs2(1));
        System.out.println(new ClimbingStaires().climbStairs2(2));
        System.out.println(new ClimbingStaires().climbStairs2(3));
        System.out.println(new ClimbingStaires().climbStairs2(4));
        System.out.println(new ClimbingStaires().climbStairs2(5));
        System.out.println(new ClimbingStaires().climbStairs2(6));
        System.out.println(new ClimbingStaires().climbStairs2(7));
        System.out.println(new ClimbingStaires().climbStairs2(8));
        System.out.println(new ClimbingStaires().climbStairs2(9));
        System.out.println(new ClimbingStaires().climbStairs2(10));
        System.out.println(new ClimbingStaires().climbStairs2(11));
        System.out.println(new ClimbingStaires().climbStairs2(12));
        System.out.println(new ClimbingStaires().climbStairs2(13));
        System.out.println(new ClimbingStaires().climbStairs2(14));
    }

}
