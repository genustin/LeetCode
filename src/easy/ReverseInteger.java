package easy;

/**
 * Created by Genustin on 11/22/14.
 * <p/>
 * Reverse digits of an integer.
 * x = 123, return 321
 * x = -123, return -321
 * x > Integer.MAX_VALUE, return 0
 */
public class ReverseInteger {
    public int reverse(int x) {
        long temp = 0;
        long div = 10;
        if (x < 10 && x > -10) return x;
        while (x / div != 0) {
            temp = temp * 10 + (x % div) / (div / 10);
            div *= 10;
        }
        temp = temp * 10 + (x % div) / (div / 10);
        if (temp >= Integer.MAX_VALUE || temp <= Integer.MIN_VALUE)
            return 0;

        return (int) temp;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(9));
    }
}
