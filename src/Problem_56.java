import java.math.BigInteger;

public class Problem_56 {
    public static void main(String[] args) {
        int max = -1;
        for (long a = 0; a < 100; a++)
        {
            for (int b= 0; b < 100; b++)
            {
                BigInteger n = BigInteger.valueOf(a).pow(b);
                if (sum(n) > max)
                {
                    max = sum(n);
                }
            }
        }
        System.out.println(max);
    }

    static int sum(BigInteger num)
    {
        int sum = 0;
        String sNum = num.toString();
        for (int n = 0; n < sNum.length(); n++)
        {
            sum += Integer.parseInt(sNum.substring(n,n+1));
        }
        return sum;
    }
}
