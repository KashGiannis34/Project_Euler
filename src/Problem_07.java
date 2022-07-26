//10001st prime
public class Problem_07 {
    public static void main(String[] args) {
        int count = 1;
        int n = 3;
        while (true)
        {
            if (prime(n))
            {
                count++;
            }

            if (count == 10001)
            {
                System.out.println(n);
                break;
            }

            n++;
        }
    }

    static boolean prime(int num)
    {
        for (int n = 2;n <= (int) Math.sqrt(num);n++)
        {
            if (num%n==0)
                return false;
        }
        return true;
    }
}
