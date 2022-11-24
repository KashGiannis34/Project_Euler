package Problems;

import java.util.HashMap;
import java.util.ArrayList;

//totient perm
public class Problem_70 {
    public static void main(String[] args) {
        double min = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        HashMap<Integer, Integer> totient = tMap(10000000);
        for (int n = 2; n <= 10000000; n++)
        {
            int tVal = totient.get(n);
            double num = n / (double) tVal;
            if (num < min && perm(tVal, n)) {
                min = num;
                minN = n;
            }
        }
        System.out.println(min + "\t" + minN);
    }

    static HashMap<Integer, Integer> tMap(int max)
    {
        HashMap<Integer, Integer> totient = new HashMap<>();
        totient.put(1,1);
        for (int n = 2; n <= max; n++)
        {
            double tVal = n;
            ArrayList<Integer> factors = pFactors(n);
            for (int factor: factors)
                tVal *= (1-(1/(double)factor));
            totient.put(n, (int) tVal);
        }
        return totient;
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

    static boolean perm(int a, int b)
    {
        String sA = Integer.toString(a);
        String sB = Integer.toString(b);
        if (sA.length() != sB.length())
            return false;

        for (int n = 0; n < sB.length(); n++)
        {
            if (!sA.contains(sB.substring(n,n+1)))
                return false;
            sA = sA.substring(0, sA.indexOf(sB.substring(n,n+1))) + sA.substring(sA.indexOf(sB.substring(n,n+1))+1);
        }
        return true;
    }
}
