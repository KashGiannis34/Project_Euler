import java.math.BigInteger;
public class Problem_20 {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("1");
        for (long n = 100; n > 1; n--) {
            x = x.multiply(BigInteger.valueOf(n));
        }
        System.out.println(x);
        char[] num = x.toString().toCharArray();
        long count = 0;
        for (char i: num) {
            count += Character.getNumericValue(i);
        }
        System.out.println(count);
    }
}
