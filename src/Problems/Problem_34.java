package Problems;//Digit factorials
import java.math.BigInteger;

public class Problem_34 {
    public static void main(String[] args) {
        BigInteger tSum = new BigInteger("0");
        BigInteger n = new BigInteger("3");
        while (true)
        {
            BigInteger num = n;
            BigInteger sum = new BigInteger("0");
            while (num.compareTo(BigInteger.valueOf(0)) == 1) {
                sum = sum.add(factorial(Integer.parseInt(num.mod(BigInteger.valueOf(10)).toString())));
                num = num.divide(BigInteger.valueOf(10));
            }


            if (sum.equals(n))
            {
                tSum = tSum.add(n);
                System.out.println(tSum);
            }
            n = n.add(BigInteger.valueOf(1));
        }

    }

    static BigInteger factorial(int n)
    {
        BigInteger[] nums = {BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(6), BigInteger.valueOf(24), BigInteger.valueOf(120), BigInteger.valueOf(720), BigInteger.valueOf(5040), BigInteger.valueOf(40320), BigInteger.valueOf(362880)};
        return nums[n];
    }
}
