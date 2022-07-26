//Permuted multiples
import java.math.BigInteger;

public class Problem_52 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("1");
        boolean sixer = false;
        while (sixer == false)
        {
            if (f6(num))
            {
                sixer = true;
            }
            System.out.println(num);
            num = num.add(BigInteger.valueOf(1));
        }
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

    static boolean f6(BigInteger num)
    {
        for (int n = 1; n <= 6; n++)
        {
            if (!perm(num.toString(), num.multiply(BigInteger.valueOf(n)).toString()))
            {
                return false;
            }
        }
        return true;
    }
}
