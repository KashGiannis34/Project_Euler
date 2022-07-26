//Lychrel numbers
import java.math.BigInteger;

public class Problem_55 {
    public static void main(String[] args) {
        int c = 0;
        for (long n =0; n < 10000; n++)
        {
            if (lych(BigInteger.valueOf(n)))
            {
                c++;
                System.out.println(n);
            }
        }
        System.out.println(c);
    }

    static boolean pal(BigInteger n)
    {
        StringBuilder sb = new StringBuilder(n.toString());
        return (sb.toString().equals(sb.reverse().toString()));
    }

    static boolean lych(BigInteger n)
    {
        int count = 0;
        while (!pal(n) || count==0)
        {
            StringBuilder sb = new StringBuilder(n.toString());
            BigInteger reverse = new BigInteger(sb.reverse().toString());
            n = n.add(reverse);
            count++;
            if (count >= 50)
            {
                return true;
            }
        }
        return false;
    }
}
