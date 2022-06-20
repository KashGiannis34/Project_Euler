import java.util.ArrayList;

public class Problem_49 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = gPrime(1000, 9999);
        for (int a = 0; a < primes.size(); a++)
        {
            for (int b = a+1; b < primes.size(); b++)
            {
                int num = 2*primes.get(b)-primes.get(a);
                if (perm(primes.get(a).toString(), primes.get(b).toString()) && inList(primes,num) && perm(Integer.toString(num),primes.get(a).toString()))
                {
                    System.out.println(primes.get(a) + "\t" + primes.get(b)+"\t"+num);
                }
            }
        }
    }

    static boolean prime(int num)
    {
        for (int n = 2; n <= Math.sqrt(num); n++)
        {
            if (num%n == 0)
            {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> gPrime(int min, int max)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int n = min; n <= max; n++)
        {
            if (prime(n))
            {
                primes.add(n);
            }
        }
        return primes;
    }

    static boolean inList(ArrayList<Integer> array, int num)
    {
        for (int n = 0; n < array.size(); n++)
        {
            if (array.get(n) == num)
            {
                return true;
            }
        }
        return false;
    }

    static boolean perm(String a, String b)
    {
        String match = "";
        for (int n = 0; n < a.length(); n++)
        {
            for (int l = 0; l < b.length(); l++)
            {
                if (a.substring(n, n+1).equals(b.substring(l,l+1)))
                {
                    match += a.substring(n,n+1);
                    b = b.substring(0,l) + b.substring(l+1);
                    break;
                }
            }
        }
        return (match.equals(a));
    }
}
