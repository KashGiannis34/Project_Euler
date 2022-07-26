import java.util.ArrayList;
import java.util.HashMap;

// totient max
public class Problem_69 {
    public static void main(String[] args) {
        double max = -1;
        int maxN = -1;
        HashMap<Integer, Integer> totient = tMap(1000000);
        for (int n = 2; n <= 1000000; n++)
        {
            double num = n / (double) totient.get(n);
            if (num > max) {
                max = num;
                maxN = n;
            }
        }
        System.out.println(max + "\t" + maxN);
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
}
