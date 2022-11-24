package Problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

// Counting fractions in a range
public class Problem_73 {
    public static void main(String[] args) {
        System.out.println(fHalf(12000).intValue()-fThird(12000));
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

    static BigInteger fHalf(int n)
    {
        BigInteger num = BigInteger.ZERO;
        for (int t = 2; t <= n; t++)
        {
            num = num.add(BigInteger.valueOf(tot(t)));
        }
        return num.subtract(BigInteger.ONE).divide(BigInteger.TWO);
    }

    static int fThird(int n)
    {
        HashSet<Double> fractions = new HashSet<>();
        for (int den = 3; den <= n; den++)
        {
            for (int num = 1; num <= den/3; num++)
            {
                double frac = num / (double) den;
                if (fractions.contains(frac))
                    continue;
                else
                    fractions.add(frac);
            }
        }
        return fractions.size();
    }
}
