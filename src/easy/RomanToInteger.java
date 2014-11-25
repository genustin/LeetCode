package easy;

/**
 * Created by Genustin on 11/24/14.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if (null == s || s.length() == 0) return 0;
        int answer = 0;
        boolean minusFlag = false;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            if (minusFlag) {
                // this one minus last one case
                temp = roi(s.charAt(i)) - roi(s.charAt(i - 1));
                minusFlag = false;
            } else if ("IXC".indexOf(s.charAt(i)) > -1
                    && i < s.length() - 1
                    && roi(s.charAt(i)) < roi(s.charAt(i + 1))) {
                // this one is I, X, C and it's smaller than next one.
                // skip this one;
                minusFlag = true;
            } else {
                // normal case
                temp = roi(s.charAt(i));
            }
            answer += temp;
        }
        return answer;
    }

    private int roi(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private void romanValidator() {

    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCD"));
        System.out.println(new RomanToInteger().romanToInt("MCDXXXVII"));
        System.out.println(new RomanToInteger().romanToInt("MD"));
        System.out.println(new RomanToInteger().romanToInt("MDCCC"));
        System.out.println(new RomanToInteger().romanToInt("MDCCCLXXX"));
        System.out.println(new RomanToInteger().romanToInt("MCM"));
        System.out.println(new RomanToInteger().romanToInt("MMMCCCXXXIII"));
    }
}
