package Problems;

import java.util.ArrayList;
import java.math.BigInteger;

//Magic 5-gon ring
public class Problem_68 {
    public static void main(String[] args) {
        ArrayList<int[]> numList = new ArrayList<>();
        ArrayList<int[]> magicList = new ArrayList<>();
        BigInteger max=  new BigInteger("-1");
        for (String s: perms("123456789A"))
        {
            int[] n = new int[10];
            for (int i = 0; i < s.length(); i++)
                n[i] = (s.substring(i,i+1).equals("A") ? 10: Integer.parseInt(s.substring(i,i+1)));
            numList.add(n);
        }
        System.out.println("Done");

        for (int[] nums: numList)
        {
            if (nums[5] == 10 || nums[6] == 10 || nums[7] == 10 || nums[8] == 10 || nums[9] == 10)
                continue;
            int[][] fGon = mapGon(nums);
            if (magic(fGon))
                magicList.add(nums);
        }

        for (int[] magic: magicList)
        {
            BigInteger val = value(magic);
            if (val.compareTo(max) == 1)
                max = val;
        }
        System.out.println(max);
        System.out.println(max.toString().length());

    }

    static int[][] mapGon(int[] nums) {
        int[][] fGon = new int[5][3];

        for (int n = 0; n < 5; n++)
        {
            fGon[n][0] = nums[n];
        }

        for (int n = 5; n < 10; n++)
        {
            fGon[n-5][1] = nums[n];
            fGon[(n-6 < 0) ? n-1:n-6][2] = nums[n];
        }
        return fGon;
    }

    static ArrayList<String> perms(String sNums)
    {
        ArrayList<String> perm = new ArrayList<>();
        if (sNums.length() == 0)
        {
            return perm;
        }
        else if (sNums.length() == 1)
        {
            perm.add(sNums);
            return perm;
        }
        else
        {
            for (int n = 0; n < sNums.length(); n++) {
                String s = sNums.substring(n, n + 1);
                String rest = sNums.substring(0, n) + sNums.substring(n + 1);
                ArrayList<String> temp = perms(rest);
                for (String s1 : temp)
                {
                    perm.add(s+s1);
                }
            }
        }
        return perm;
    }

    static boolean magic(int[][] fGon)
    {
        int sum = 0;
        for (int n = 0; n < fGon[0].length;n++)
        {
            sum += fGon[0][n];
        }

        for (int n = 1; n < fGon.length; n++)
        {
            int sum2 = 0;
            for (int num: fGon[n])
            {
                sum2 += num;
            }
            if (sum2 != sum)
                return false;
        }
        return true;
    }

    static BigInteger value(int[] nums)
    {
        String val = "";
        int min = 11;
        int minI = -1;
        for (int n = 0; n < 5; n++)
        {
            if (nums[n] < min)
            {
                min = nums[n];
                minI = n;
            }
        }
        int[][] fGon = mapGon(nums);
        for (int n = 0; n < 5; n++)
        {
            for (int n2 = 0; n2 < 3; n2++)
            {
                val += Integer.toString(fGon[(minI+n)%5][n2]);
            }
        }
        return new BigInteger(val);
    }
}
