//Goldbach's other conjecture
import java.util.ArrayList;

public class Problem_46 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        int max = 9999999;
        pArray(primes,max);

        for (int n = 3; n <= max; n+=2)
        {
            if (!primable(n,primes))
            {
                System.out.println("n: " + n);
                break;
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

    static boolean primable(int num, ArrayList<Integer> primes)
    {
        for (int n = 0; n < primes.size(); n++)
        {
            if (primes.get(n) > num)
            {
                return false;
            }

            if (square((num - primes.get(n))/2))
            {
                return true;
            }

        }
        return false;
    }

    static void pArray(ArrayList<Integer> primes, int max)
    {
        for (int n = 3; n <= max; n++)
        {
            if (prime(n))
            {
                primes.add(n);
            }
        }
    }

    static boolean square(int num)
    {
        if (Math.pow((int) Math.sqrt(num),2) != num)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
