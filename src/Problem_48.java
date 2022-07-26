//Self powers
import java.math.BigInteger;
public class Problem_48 {
    public static void main(String[] args) {
        BigInteger count = new BigInteger("1");
        BigInteger tenDig = new BigInteger("0");
        while (count.compareTo(BigInteger.valueOf(1001)) == -1)
        {
            tenDig = tenDig.add(count.pow(Integer.parseInt(count.toString())));
            if (tenDig.toString().length() > 10)
            {
                tenDig = new BigInteger(tenDig.toString().substring(tenDig.toString().length()-10));
            }
            count = count.add(BigInteger.valueOf(1));
        }
        System.out.println(tenDig);
    }
}
