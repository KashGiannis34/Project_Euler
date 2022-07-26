//Largest prime factor
public class Problem_03 {
    public static void main(String[] args) {
        long num = 600851475143L;
        while (true)
        {
            for (int n = 3; n <= (int) Math.sqrt(num); n+=2)
            {
                if (num % n == 0 && prime(n))
                {
                    num /= n;
                    break;
                }
            }

            if (prime(num))
            {
                System.out.println(num);
                break;
            }
        }
    }

    static boolean prime(long num)
    {
        for (int n = 2; n <= (int) Math.sqrt(num); n++)
        {
            if (num%n==0)
                return false;
        }
        return true;
    }
}
