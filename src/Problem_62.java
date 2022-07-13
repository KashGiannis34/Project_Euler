import java.math.BigInteger;
import java.util.*;


public class Problem_62 {
    private static HashMap<BigInteger, Integer> cubes = new HashMap<>();
    private static ArrayList<BigInteger> smallSet = new ArrayList<>();
    public static void main(String[] args) {
        long count = 1;
        BigInteger num = new BigInteger("1");
        while (true)
        {
            num = BigInteger.valueOf(count).pow(3);
            BigInteger bigNum = lPerm(num);
            if (cubes.containsKey(bigNum))
            {
                int val = cubes.get(bigNum)+1;
                cubes.remove(bigNum);
                cubes.put(bigNum, val);
            }
            else
            {
                cubes.put(bigNum, 1);
                smallSet.add(num);
            }

            if (cubes.containsValue(5))
            {
                for (BigInteger n: cubes.keySet())
                {
                    if (cubes.get(n) == 5)
                    {
                        System.out.println(n);
                        for (BigInteger small: smallSet)
                        {
                            if (permutation(small, n))
                            {
                                System.out.println(small);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            count++;
        }
    }

    static BigInteger lPerm(BigInteger num) {
        Integer[] splitNum = new Integer[num.toString().length()];
        for (int n = 0; n < splitNum.length; n++)
        {
            splitNum[n] = Integer.parseInt(num.toString().substring(n, n+1));
        }
        Arrays.sort(splitNum, Collections.reverseOrder());
        String sNum = "";
        for (int n = 0; n < splitNum.length; n++)
        {
            sNum += splitNum[n].toString();
        }
        return new BigInteger(sNum);
    }

    static boolean permutation(BigInteger a, BigInteger b)
    {
        String sA = a.toString();
        String sB = b.toString();
        if (sA.length() != sB.length())
        {
            return false;
        }

        for (int n = 0; n < sA.length(); n++)
        {
            if (!sB.contains(sA.substring(n,n+1)))
            {
                return false;
            }
            else
            {
                sB = sB.substring(0, sB.indexOf(sA.substring(n,n+1))) + sB.substring(sB.indexOf(sA.substring(n,n+1))+1);
            }
        }

        return true;
    }
}
