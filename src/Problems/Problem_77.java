package Problems;

import java.util.*;

public class Problem_77 {
    private static ArrayList<Integer> primes = gPrimes(100);
    private static HashSet<Integer> hashPrimes = hPrimes(100);
    public static void main(String[] args) {
        int n = 4;
        while (true)
        {
            int sum = summates(n,false).size();
            System.out.println(n + "\t\t" + sum);
            if (sum > 5000)
                break;
            n++;
        }
    }

    static HashSet<HashMap<Integer, Integer>> summates(int n, boolean sub)
    {
        HashSet<HashMap<Integer, Integer>> perms = new HashSet<>();
        if (n <= 1)
            return perms;
        if (hashPrimes.contains(n) && sub) {
            HashMap<Integer, Integer> perm = new HashMap<>();
            perm.put(n,1);
            perms.add(perm);
            return perms;
        }
        for (int prime: primes)
        {
            if (prime >= n || (n-prime < prime && hashPrimes.contains(n-prime))) {
                break;
            }

            HashSet<HashMap<Integer, Integer>> combs = summates(n-prime, true);
            for (HashMap<Integer, Integer> comb: combs)
            {
                HashMap<Integer, Integer> perm = comb;
                if (perm.containsKey(prime))
                {
                    int temp = perm.get(prime)+1;
                    perm.remove(prime);
                    perm.put(prime,temp);
                }
                else
                {
                    perm.put(prime,1);
                }
                perms.add(perm);
            }
        }
        return perms;
    }

    static ArrayList<Integer> gPrimes(int max)
    {
        ArrayList<Integer> primesL = new ArrayList<>();
        for (int n = 2; n <= max; n++)
        {
            boolean prime = true;
            for (int f = 2; f < n; f++)
            {
                if (n%f == 0)
                {
                    prime = false;
                    break;
                }
            }
            if (prime)
                primesL.add(n);
        }
        return primesL;
    }

    static HashSet<Integer> hPrimes(int max)
    {
        HashSet<Integer> primesL = new HashSet<>();
        for (int n = 2; n <= max; n++)
        {
            boolean prime = true;
            for (int f = 2; f < n; f++)
            {
                if (n%f == 0)
                {
                    prime = false;
                    break;
                }
            }
            if (prime)
                primesL.add(n);
        }
        return primesL;
    }
}
