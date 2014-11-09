package easy;

/**
 * Created by Genustin on 11/9/14.
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!(Character.isLetterOrDigit(s.charAt(i)))) {
                i++;
                continue;
            } else if (!(Character.isLetterOrDigit(s.charAt(j)))) {
                j--;
                continue;
            } else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "1a2";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(a));
    }

}
