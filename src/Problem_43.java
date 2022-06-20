import java.util.ArrayList;

public class Problem_43 {
    public static void main(String[] args) {
        ArrayList<String> combin = comb("0123456789");
        int[] primes = {2,3,5,7,11,13,17};
        for (int n = 0; n < combin.size(); n++)
        {
            boolean pan = true;
            int[] dig = digits(combin.get(n));
            if (dig[0] == 0)
            {
                continue;
            }
            for (int pos = 1; pos <= 7; pos++)
            {
                if ((dig[pos]*100+dig[pos+1]*10+dig[pos+2])%primes[pos-1] !=0)
                {
                    pan = false;
                }
            }

            if (pan)
            {
                System.out.println(combin.get(n));
            }
        }
    }

    static ArrayList<String> comb(String sNum)
    {
        ArrayList<String> sNums = new ArrayList<String>();
        if (sNum.length() == 0)
        {
            return sNums;
        }
        else if(sNum.length() == 1)
        {
            sNums.add(sNum);
            return sNums;
        }
        else
        {
            for (int n = 0; n < sNum.length(); n++)
            {
                String fDig = sNum.substring(n, n+1);
                String rNum = sNum.substring(0,n) + sNum.substring(n+1, sNum.length());

                ArrayList<String> temp = comb(rNum);
                for (int n1 = 0; n1 < temp.size();n1++)
                {
                    sNums.add(fDig+temp.get(n1));
                }
            }
        }
        return sNums;
    }

    static int[] digits(String sNum)
    {
        int[] dig = new int[sNum.length()];
        for (int n = 0; n < sNum.length(); n++)
        {
            dig[n] = Integer.parseInt(sNum.substring(n,n+1));
        }
        return dig;
    }
}
