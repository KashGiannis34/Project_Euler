//Distinct primes factors
import java.util.ArrayList;

public class Problem_47 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> p4s = new ArrayList<>();
        int max = 9999999;
        pArray(primes,max);
        System.out.println("pArray Done");
        int count = 0;
        for (int n = 4; n <= max; n++)
        {
            if (p4Factors(n, primes))
            {
                p4s.add(n);
                count++;
                if (count == 4)
                {
                    System.out.println(p4s.get(0));
                    break;
                }
            }
            else
            {
                count = 0;
                p4s.clear();
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

    static void pArray(ArrayList<Integer> primes, int max)
    {
        primes.add(2);
        for (int n = 3; n <= max; n++)
        {
            if (prime(n))
            {
                primes.add(n);
            }
        }
    }

    static boolean p4Factors(int num, ArrayList<Integer> primes)
    {
        int factors = 0;
        ArrayList<Integer> lFactor = new ArrayList<>();
        while (factors <= 3)
        {
            int n = 0;
            while (true)
            {
                int prime = primes.get(n);
                if (prime > num)
                {
                    return false;
                }

                if (num % prime == 0)
                {
                    if (unique(lFactor, prime))
                    {
                        lFactor.add(prime);
                        factors++;
                    }
                    num /= prime;
                    break;
                }
                n++;
            }
        }

        if (num == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    static boolean unique(ArrayList<Integer> array, int num)
    {
        for (int n = 0; n < array.size(); n++)
        {
            if (array.get(n) == num)
            {
                return false;
            }
        }
        return true;
    }
}
