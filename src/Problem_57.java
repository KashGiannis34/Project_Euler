//Square root convergents
import java.math.BigInteger;

public class Problem_57 {
    public static void main(String[] args) {
        int count = 0;
        for (int n = 1; n <= 1000; n++)
        {
            BigInteger[] nums = iter(n);
            if (nums[0].toString().length() > nums[1].toString().length())
            {
                count++;
            }
        }
        System.out.println(count);
    }

    static BigInteger[] iter(int num)
    {
        BigInteger[] frac = {BigInteger.valueOf(3),BigInteger.valueOf(2)};
        for (long n = 1; n < (long) num; n++)
        {
            BigInteger denom = frac[0].add(frac[1]);
            frac[0] = denom.add(frac[1]);
            frac[1] = denom;
        }
        return frac;
    }
}
