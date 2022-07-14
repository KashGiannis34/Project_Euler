public class Problem_10 {
    public static void main(String[] args) {
        long sum = 0;
        for (int n = 2; n < 2000000; n++)
            sum += (prime(n) ? n:0);
        System.out.println(sum);
    }

    static boolean prime(int num)
    {
        for (int n = 2; n <= (int) Math.sqrt(num); n++)
        {
            if (num%n==0)
                return false;
        }
        return true;
    }
}
