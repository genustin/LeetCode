package easy;

/**
 * Created by Genustin on 12/25/14.
 * <p/>
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) return -1;
        if (haystack.length() < needle.length()) return -1;
        // empty needle
        if (needle.equals("")) return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int k = 0;
            for (; k < needle.length()
                    && haystack.charAt(i + k) == needle.charAt(k); k++) { }
            if (k == needle.length()) return i;
        }
        return -1;
    }
}
