package Problems;

import java.util.HashSet;

//Digit factorial chains
public class Problem_74 {
    public static void main(String[] args) {
        int count = 0;
        for (int n = 1; n <= 1000000; n++)
        {
            if (fChain60(n))
            {
                count++;
            }
        }
        System.out.println(count);
    }

    static int f(int n)
    {
        int[] fS = {1,1,2,6,24,120,720,5040,40320,362880,3628800};
        return fS[n];
    }

    static int fSum(int n)
    {
        String sN = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < sN.length(); i++)
        {
            sum += f(Integer.parseInt(sN.substring(i,i+1)));
        }
        return sum;
    }

    static boolean fChain60(int n)
    {
        HashSet<Integer> nums = new HashSet<>();
        int num = n;
        nums.add(num);
        while (nums.size() <= 60)
        {
            num = fSum(num);
            if (nums.contains(num)) {
                if (nums.size() == 60)
                    return true;
                else
                    return false;
            }
            else
                nums.add(num);
        }
        return false;
    }
}
