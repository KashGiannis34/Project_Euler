import java.util.ArrayList;

public class Problem_50 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = gPrime(2,1000000);
        int maxCount = -1;
        for (int n = 0; n<primes.size(); n++)
        {
            int sum = primes.get(n);
            int n1 = n+1;
            int count = 1;
            int tCount = -1;
            int tMax = -1;
            while (n1 < primes.size() && sum < 1000000)
            {
                sum+=primes.get(n1);
                count++;
                if (prime(sum))
                {
                    tMax = sum;
                    tCount = count;
                }
                n1++;
            }

            if (tCount > maxCount)
            {
                maxCount=tCount;
                System.out.println("sum: " + tMax + "\t" + "count: " + tCount + "\t" + "Start: " + primes.get(n));
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
}
