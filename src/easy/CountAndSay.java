package easy;

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
 * Note: the CountAndSay always start from "1";
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String say = "1";
        for (int k = 1; k < n; k++) {
            say = count(say);
        }
        return say;
    }

    private String count(String str) {
        String out = "";
        int k = 0;
        while (k < str.length()) {
            char ptr = str.charAt(k);
            int num = 0;
            while (k < str.length() && str.charAt(k) == ptr) {
                k++;
                num++;
            }
            out = out.concat(String.valueOf(num)).concat(String.valueOf(ptr));
        }
        return out;
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(10));
    }
}
