import java.math.BigInteger;
public class Problem_15 {
    public static BigInteger ncr(int n, int r) {
        BigInteger num = new BigInteger("1");
        for (int len = 0; len < r; len++) {
            num = num.multiply(BigInteger.valueOf(n - len));
        }
        for (int len = 2; len <= r; len++) {
            num = num.divide(BigInteger.valueOf(len));
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(ncr(40,20));
    }
}
