//Highly divisible triangular number
public class Problem_12 {
    public static void main(String[] args) {
        int n = 1;
        int count = 2;
        while (true)
        {
            if (factors(n) > 500) {
                System.out.println(n);
                break;
            }

            n+= count;
            count++;
        }
    }

    static int factors(int num)
    {
        int factor = 2;
        for (int n = 2; n <= (int) Math.sqrt(num); n++)
        {
            if (num%n == 0)
                factor += 2;
        }
        return factor;
    }
}
