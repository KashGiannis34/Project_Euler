//Prime pair sets
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class Problem_60 {
    static ArrayList<Integer> primes(int upper) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(-1);
        for (int n = 2; n <= upper; n++)
        {
            nums.add(n);
        }

        for (int n = 2; n <= (int) Math.ceil(Math.sqrt(upper)); n++)
        {
            if (nums.get(n) == -1)
            {
                continue;
            }
            else
            {
                for (int m = n*2; m <= upper; m += n)
                {
                    nums.set(m, -1);
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int n = 0; n < nums.size(); n++)
        {
            if (nums.get(n) != -1)
            {
                primes.add(n);
            }
        }
        return primes;
    }
    private static ArrayList<Integer> primeL = primes(30000);

   public static void main(String[] args) {
       HashSet[] pairs = new HashSet[primeL.size()];
       int minSum = Integer.MAX_VALUE;
       for (int a = 0; a < primeL.size() - 4; a++)
       {
           if (primeL.get(a)*5 >= minSum)
               break;
           if (pairs[a] == null)
               pairs[a] = concats(a);

           for (int b = a+1; b < primeL.size() - 3; b++)
           {
               if (primeL.get(b)*4+primeL.get(a) >= minSum)
                   break;
               if (pairs[b] == null)
                   pairs[b] = concats(b);
               if (!pairs[a].contains(primeL.get(b)))
                   continue;
               for (int c = b+1; c < primeL.size() - 2; c++)
               {
                   if (primeL.get(c)*3+primeL.get(b)+primeL.get(a) >= minSum)
                       break;
                   if (pairs[c] == null)
                       pairs[c] = concats(c);
                   if (!pairs[a].contains(primeL.get(c)) || !pairs[b].contains(primeL.get(c)))
                       continue;
                   for (int d = c+1; d < primeL.size() - 1; d++)
                   {
                       if (primeL.get(d)*2+primeL.get(c)+primeL.get(b)+primeL.get(a) >= minSum)
                           break;
                       if (pairs[d] == null)
                           pairs[d] = concats(d);
                       if (!pairs[a].contains(primeL.get(d)) || !pairs[b].contains(primeL.get(d)) || !pairs[c].contains(primeL.get(d)))
                           continue;
                       for (int e = d+1; e < primeL.size(); e++)
                       {
                           if (primeL.get(a)+primeL.get(b)+primeL.get(c)+primeL.get(d)+primeL.get(e) >= minSum)
                               break;
                           if (pairs[e] == null)
                               pairs[e] = concats(e);
                           if (!pairs[a].contains(primeL.get(e)) || !pairs[b].contains(primeL.get(e)) || !pairs[c].contains(primeL.get(e)) || !pairs[d].contains(primeL.get(e)))
                           {
                               continue;
                           }
                           else
                           {
                               if (primeL.get(a)+primeL.get(b)+primeL.get(c)+primeL.get(d)+primeL.get(e) < minSum)
                               {
                                   minSum = primeL.get(a)+primeL.get(b)+primeL.get(c)+primeL.get(d)+primeL.get(e);
                                   System.out.println(minSum);
                                   System.out.println(primeL.get(a)+" "+primeL.get(b)+" "+primeL.get(c)+" "+primeL.get(d)+" "+primeL.get(e));
                               }
                           }
                       }
                   }
               }
           }
       }
   }

   static boolean prime(BigInteger num)
   {
       for (BigInteger n = BigInteger.valueOf(2); n.compareTo(num.sqrt().add(new BigInteger("1"))) == -1; n = n.add(new BigInteger("1")))
       {
           if (num.mod(n).compareTo(BigInteger.valueOf(0)) == 0)
           {
               return false;
           }
       }
       return true;
   }

   static HashSet<Integer> concats(int a)
   {
       HashSet<Integer> concatP = new HashSet<>();

       for (int b = a+1; b < primeL.size(); b++)
       {
           if (prime(new BigInteger(Integer.toString(primeL.get(a))+Integer.toString(primeL.get(b)))) && prime(new BigInteger(Integer.toString(primeL.get(b))+Integer.toString(primeL.get(a)))))
           {
               concatP.add(primeL.get(b));
           }
       }
       return concatP;
   }


}