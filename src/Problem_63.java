//Powerful digit counts
import java.math.BigInteger;

public class Problem_63 {
    public static void main(String[] args) {
        int count = 9;
        int dig = 2;
        while (true)
        {
            BigInteger n = new BigInteger("2");
            while (true)
            {
                BigInteger num = n.pow(dig);
                if (num.toString().length() > dig)
                {
                    break;

                }
                else if (num.toString().length() == dig)
                {
                    count++;
                    System.out.println(count + " " + num);
                }

                n = n.add(BigInteger.valueOf(1));
            }
            dig++;
        }
    }
}
