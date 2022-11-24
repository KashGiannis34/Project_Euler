package Problems;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

//ordered fractions
public class Problem_71 {
    public static void main(String[] args) {
        int numer = 0;
        for (int n = 1; n <= 1000000; n++)
        {
            if (n%7==0)
                continue;
            int temp = BigDecimal.valueOf(n).multiply(BigDecimal.valueOf(3)).divide(BigDecimal.valueOf(7), 10, RoundingMode.HALF_UP).intValue();

            BigInteger one = BigInteger.valueOf(n).multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(temp).multiply(BigInteger.valueOf(7)));
            if (one.compareTo(BigInteger.ONE) == 0)
                numer = temp;
        }
        System.out.println(numer);
    }

}
