import java.util.ArrayList;
public class Problem_41 {
    public static void main(String[] args) {
        long max = 0;
        for (int n = 1; n < 9; n++)
        {
            String sNum = "";
            for (int num = 1; num <= n; num++)
            {
                sNum += Integer.toString(num);
            }

            ArrayList<String> perms = comb(sNum);
            for (int p = 0; p < perms.size(); p++)
            {
                if (prime(Integer.parseInt(perms.get(p))))
                {
                    max = Long.parseLong(perms.get(p));
                    System.out.println(max);
                }
            }
        }

    }

    static boolean prime(int num) {
        for (int n = 2; n <= Math.sqrt(num); n++)
        {
            if (num % n == 0)
            {
                return false;
            }
        }
        return true;
    }

    static ArrayList<String> comb(String sNum)
    {
        ArrayList<String> sNums = new ArrayList<String>();
        if (sNum.length() == 0)
        {
            return sNums;
        }
        else if (sNum.length() == 1)
        {
            sNums.add(sNum);
            return sNums;
        }
        else
        {
            for (int n = 0; n < sNum.length(); n++)
            {
                String sFirst = sNum.substring(n, n+1);
                String sRest = sNum.substring(0,n)+sNum.substring(n+1);
                ArrayList<String> perms = comb(sRest);
                for (int s = 0; s < perms.size(); s++)
                {
                    sNums.add(sFirst+perms.get(s));
                }
            }
            return sNums;
        }
    }
}
