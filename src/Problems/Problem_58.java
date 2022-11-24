package Problems;

//Spiral primes
public class Problem_58 {
    public static void main(String[] args) {
        double percent = 1;
        int len = 3;
        int primes = 0;
        while (true)
        {
            int d1 = len*len - len + 1;
            int d2 = len*len - 2*len + 2;
            int d3 = len*len - 3*len + 3;
            primes += (prime(d1) + prime(d2) + prime(d3));
            percent = (double) (primes)/(2*len-1);
            if (percent < 0.1)
            {
                System.out.println(len);
                break;
            }
            len += 2;
        }
    }

    static int prime(int num)
    {
        for (int n = 2; n <= Math.sqrt(num); n++)
        {
            if (num%n == 0)
            {
                return 0;
            }
        }
        return 1;
    }
}
