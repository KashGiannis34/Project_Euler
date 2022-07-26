//Pandigital multiples
public class Problem_38 {
    public static void main(String[] args) {
        int p = 0;
        long max = 0;
        while (true)
        {
            String pr = prod(p);
            if (pan(pr) && Integer.parseInt(pr)>max)
            {
                System.out.println("p = " + p);
                System.out.println("new max = " + pr);
                max = Long.parseLong(pr);
            }
            p++;
        }
    }

    static String prod(int num)
    {
        String sNum = "";
        int n = 1;
        while (sNum.length() < 9)
        {
            sNum += Integer.toString(num*n);
            n++;
        }
        if (n <= 2)
        {
            return "0";
        }
        return sNum;
    }

    static boolean pan(String sNum)
    {
        if (sNum.length() != 9)
        {
            return false;
        }
        else
        {
            boolean[] nums = {true, true, true, true, true, true, true, true, true, true};
            for (int n = 0; n < sNum.length(); n++)
            {
                if (sNum.substring(n,n+1).equals("0"))
                {
                    return false;
                }

                if (nums[Integer.parseInt(sNum.substring(n,n+1))] == true)
                {
                    nums[Integer.parseInt(sNum.substring(n,n+1))] = false;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
