//Combinatoric selections
import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_53 {
    public static void main(String[] args) {
        ArrayList<BigInteger> nums = new ArrayList<>();
        for (int r = 1; r <= 100; r++)
        {
            for (int n = 100; n >= r; n--)
            {
                BigInteger num = ncr(n,r);
                if (num.compareTo(BigInteger.valueOf(1000000)) != 1)
                {
                    break;
                }
                else
                {
                    nums.add(num);
                }
            }
        }
        System.out.println(nums.size());
    }

    static BigInteger ncr(int n, int r)
    {
        BigInteger sum1 = new BigInteger("1");
        BigInteger sum2 = new BigInteger("1");
        for (int c = 0; c < r; c++)
        {
            sum1 = sum1.multiply(BigInteger.valueOf(n-c));
            sum2 = sum2.multiply(BigInteger.valueOf(c+1));
        }

        return sum1.divide(sum2);
    }
}
