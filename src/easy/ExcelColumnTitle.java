package easy;

/**
 * Created by Genustin on 12/25/14.
 * <p/>
 * Given a positive integer, return its corresponding column title
 * as appear in an Excel sheet
 */
public class ExcelColumnTitle {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        String MAP = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        int size = MAP.length();
        int num = n;
        long div = 0;
        long mul = 1;
        int len = 0;
        while (num > div) {
            len++;
            mul = mul * size;
            div = mul + div;
        }

        char[] output = new char[len];
        int reminder = 0;
        for (int i = len - 1; i >= 0; i--) {
            reminder = num % size;
            output[i] = MAP.charAt(reminder);
            if (reminder == 0)
                num = (num - size) / size;
            else
                num = (num - num % size) / size;
        }
        return String.valueOf(output);
    }

    public static void main(String[] args) {
        ExcelColumnTitle ect = new ExcelColumnTitle();
        System.out.println(ect.convertToTitle(1));
        System.out.println(ect.convertToTitle(2));
        System.out.println(ect.convertToTitle(3));
        System.out.println(ect.convertToTitle(5));
        System.out.println(ect.convertToTitle(8));
        System.out.println(ect.convertToTitle(13));
        System.out.println(ect.convertToTitle(21));
        System.out.println(ect.convertToTitle(27));
        System.out.println(ect.convertToTitle(52));
        System.out.println(ect.convertToTitle(53));
        System.out.println(ect.convertToTitle(55));
        System.out.println(ect.convertToTitle(1000000001));
    }
}