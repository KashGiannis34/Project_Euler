package Problems;//Triangular, pentagonal, and hexagonal
import java.math.BigInteger;
import java.util.HashMap;

public class Problem_45 {
    static BigInteger max = new BigInteger("10000000000");
    public static void main(String[] args) {
        HashMap<BigInteger,Integer> pents = new HashMap<>();
        addPent(pents);

        HashMap<BigInteger,Integer> hexas = new HashMap<>();
        addHexa(hexas);

        HashMap<Integer, BigInteger> tris = new HashMap<>();
        addTri(tris);

        System.out.println("Computed");

        for (int a = 1; a < tris.size(); a++)
        {
            BigInteger num = tris.get(a);

            if (pents.get(num) != null && hexas.get(num) != null)
            {
                System.out.println(num);
            }

        }
    }

    static BigInteger tri(int n)
    {
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
    }

    static BigInteger pent(int n)
    {
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(3*n-1)).divide(BigInteger.valueOf(2));
    }

    static BigInteger hexa(int n)
    {
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(2*n-1));
    }

    static void addPent(HashMap<BigInteger,Integer> pents)
    {
        int n = 1;
        while (pent(n).compareTo(max) == -1)
        {
            pents.put(pent(n),n);
            n++;
        }
    }

    static void addTri(HashMap<Integer, BigInteger> tris)
    {
        int n = 1;
        while (tri(n).compareTo(max) == -1)
        {
            tris.put(n,tri(n));
            n++;
        }
    }

    static void addHexa(HashMap<BigInteger,Integer> hexas)
    {
        int n = 1;
        while (hexa(n).compareTo(max) == -1)
        {
            hexas.put(hexa(n),n);
            n++;
        }
    }
}
