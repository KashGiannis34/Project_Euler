package Problems;//Diophantine equation
import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_66 {
    public static void main(String[] args) {
        BigInteger max = BigInteger.valueOf(-1);
        int d = -1;
        for (int n = 2; n <= 1000; n++)
        {
            if (n != Math.pow((int) Math.sqrt(n),2)) {
                BigInteger num = minSol(n);
                if (num.compareTo(max) == 1) {
                    max = num;
                    d = n;
                }
            }
        }
        System.out.println(d + ": " + max);
    }

    static ArrayList<Integer> frac(int num)
    {
        ArrayList<Integer> aSeries = new ArrayList<>();
        ArrayList<String> radicals = new ArrayList<>();
        int sub = (int) Math.sqrt(num);
        int numer = 1;
        while (true)
        {
            int den = (num - sub*sub)/numer;
            String rad = "(sqrt(" + num + ") + " + sub + ") /" + den;
            if (radicals.contains(rad))
                break;
            else
                radicals.add(rad);

            int a = 0;
            while (sub - den >= (int) Math.sqrt(num)*-1)
            {
                sub -= den;
                a++;
            }
            sub = Math.abs(sub);
            aSeries.add(a);
            numer = den;
        }
        return aSeries;
    }

    static BigInteger[] converge(int num, int i)
    {
        BigInteger[] fraction = new BigInteger[2];
        ArrayList<Integer> continued = frac(num);
        fraction[0] = BigInteger.valueOf(num).sqrt();
        BigInteger prev0 = BigInteger.valueOf(1);
        fraction[1] = BigInteger.valueOf(1);
        BigInteger prev1 = BigInteger.valueOf(0);
        for (int n = 0; n < i; n++)
        {
            BigInteger temp0 = fraction[0];
            BigInteger temp1 = fraction[1];
            fraction[0] = fraction[0].multiply(BigInteger.valueOf(continued.get(n%continued.size()))).add(prev0);
            fraction[1] = fraction[1].multiply(BigInteger.valueOf(continued.get(n%continued.size()))).add(prev1);
            prev0 = temp0;
            prev1 = temp1;
        }
        return fraction;
    }

    static BigInteger minSol(int num)
    {
        int i = 0;
        while (true)
        {
            BigInteger[] frac = converge(num, i);
            if (frac[0].pow(2).subtract(BigInteger.valueOf(num).multiply(frac[1].pow(2))).compareTo(BigInteger.valueOf(1)) == 0)
                return frac[0];
            i++;
        }
    }
}
