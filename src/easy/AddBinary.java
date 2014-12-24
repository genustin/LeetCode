package easy;

/**
 * Created by Genustin on 12/24/14.
 * <p/>
 * Given two binary strings, return their sum (also a binary string)
 * For example, a = "11", b = "1", return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int len1, len2;
        String c = ""; // first half of longer string.
        String d; // second half of longer string.
        String e; // shorter string.
        if (a.length() > b.length()) {
            len2 = b.length();
            len1 = a.length() - b.length();
            e = b;
            d = a.substring(len1, a.length());
            c = a.substring(0, len1);
        } else if (a.length() < b.length()) {
            len2 = a.length();
            len1 = b.length() - a.length();
            e = a;
            d = b.substring(len1, b.length());
            c = b.substring(0, len1);
        } else {
            len2 = a.length();
            len1 = 0;
            e = b;
            d = a;
        }

        // handle the common part
        char[] secondPart = new char[len2];
        char x = '0';
        for (int i = len2 - 1; i >= 0; i--) {
            if (e.charAt(i) == '0' && d.charAt(i) == '0') {
                secondPart[i] = x;
                x = '0';
            } else if (e.charAt(i) == '1' && d.charAt(i) == '1') {
                secondPart[i] = x;
                x = '1';
            } else {
                if (x == '0') secondPart[i] = '1';
                else secondPart[i] = '0';
            }
        }

        // handle the longer part
        if (len1 != 0) {
            if (x == '1') {
                char[] firstPart = new char[len1];
                for (int i = len1 - 1; i >= 0; i--) {
                    if (c.charAt(i) == '0' && x == '0') {
                        firstPart[i] = '0';
                    } else if (c.charAt(i) == '1' && x == '1') {
                        firstPart[i] = '0';
                    } else {
                        firstPart[i] = '1';
                        x = '0';
                    }
                }
                c = String.valueOf(firstPart) + String.valueOf(secondPart);
            } else {
                c = c + String.valueOf(secondPart);
            }
        } else {
            c = String.valueOf(secondPart);
        }

        if (x == '1')
            return "1" + c;
        else
            return c;
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        ab.addBinary("0", "1");
    }
}
