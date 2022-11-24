package Problems;//Truncatable primes
import java.util.ArrayList;
public class Problem_37 {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        for (int n = 10; n < 1000000000; n++)
        {
            ArrayList<Integer> perm1 = trunc(n);
            ArrayList<Integer> perm2 = trunc2(n);
            boolean tPrime = true;
            for (int n1 = 0; n1 <perm1.size(); n1++)
            {
                if (!prime(perm1.get(n1)))
                {
                    tPrime = false;
                }
            }

            for (int n2 = 0; n2 <perm2.size(); n2++)
            {
                if (!prime(perm2.get(n2)))
                {
                    tPrime = false;
                }
            }

            if (tPrime == true)
            {
                System.out.println("num: "+n);
                sum+= n;
                System.out.println("Sum: " + sum);
                count++;
                System.out.println("Count: " + count);

                System.out.println();
            }
        }
    }

    static boolean prime(int num) {
        if (num < 2)
        {
            return false;
        }
        for (int n = 2; n <= Math.sqrt(num); n++)
        {
            if (num % n == 0)
            {
                return false;
            }
        }
        return true;
    }

    static ArrayList<Integer> trunc(int num)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(num);
        for (int n = (int) Math.log10(num); n > 0; n--)
        {
            num = num - (int) (((int) (num / Math.pow(10, n)))*Math.pow(10,n));
            if (num == 0)
            {
                return nums;
            }
            nums.add(num);
        }
        return nums;
    }

    static ArrayList<Integer> trunc2(int num) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(num);
        while(num != 0)
        {
            num /= 10;
            if (num == 0)
            {
                return nums;
            }
            nums.add(num);
        }
        return nums;
    }
}
