package Problems;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem_78 {
    private static HashMap<Integer, BigInteger> pMap = new HashMap<>();
    public static void main(String[] args) {
        int n = 2;
        while (true)
        {
            if (p(n).mod(BigInteger.valueOf(1000000)).compareTo(BigInteger.ZERO) == 0) {
                System.out.println(n + "\t\t" + p(n));
                break;
            }
            n++;
        }
    }

    static int g(int n)
    {
        if (n<=0)
            return 0;
        int k = (n%2 == 0 ? -1*(n+1)/2:(n+1)/2);
        return k*(3*k-1)/2;
    }

    static BigInteger p(int n)
    {
        if (n == 0 || n == 1)
            return BigInteger.ONE;

        if (pMap.containsKey(n))
            return pMap.get(n);
        else
        {
            int count = 1;
            BigInteger sum = BigInteger.ZERO;
            while (g(count) <= n) {
                if (count % 4 == 1 || count % 4 == 2)
                    sum = sum.add(p(n - g(count)));
                else
                    sum = sum.subtract(p(n - g(count)));
                count++;
            }
            pMap.put(n, sum);
            return sum;
        }
    }
}
