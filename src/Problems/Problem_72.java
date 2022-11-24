package Problems;

import java.math.BigInteger;
import java.util.ArrayList;

// counting fractions
public class Problem_72 {
    public static void main(String[] args) {
        System.out.println(f(1000000));
    }

    static int tot(int n)
    {
        double tVal = n;
        ArrayList<Integer> factors = pFactors(n);
        for (int factor: factors)
            tVal *= (1-(1/(double)factor));
        return (int) tVal;
    }

    static ArrayList<Integer> pFactors(int n)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        while (n > 1)
        {
            boolean prime = true;
            for (int f = 2; f <= Math.sqrt(n); f++)
            {
                if (n%f == 0)
                {
                    n /= f;
                    if (!factors.contains(f))
                        factors.add(f);
                    prime = false;
                    break;
                }
            }
            if (prime)
            {
                if (!factors.contains(n))
                    factors.add(n);
                return factors;
            }
        }
        return factors;
    }

    static BigInteger f(int n)
    {
        BigInteger num = BigInteger.ZERO;
        for (int t = 2; t <= n; t++)
        {
            num = num.add(BigInteger.valueOf(tot(t)));
        }
        return num;
    }
}
