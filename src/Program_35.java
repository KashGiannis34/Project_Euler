import java.util.ArrayList;

public class Program_35 {
    public static void main(String[] args) {
        int count = 0;

        for (int n = 2; n < 1000000; n++) {
            if (rPrime(n))
            {
                count++;
                System.out.println(n);
            }
        }
        System.out.println(count);
    }

    static boolean prime(int n)
    {
        for (int a = 2; a <= Math.sqrt(n); a++)
        {
            if (n%a==0)
            {
                return false;
            }
        }
        return true;
    }

    static boolean rPrime(int n)
    {
        ArrayList<Integer> perms = comb(n);
        for (int l = 0; l < perms.size(); l++)
        {
            if (!prime(perms.get(l)))
            {
                return false;
            }
        }
        return true;
    }


    static ArrayList<String> comb(String sNum) {
        ArrayList<String> lis = new ArrayList<String>();
        for (int n = 0; n < sNum.length(); n++)
        {
            sNum = sNum.substring(1, sNum.length()) + sNum.substring(0, 1);
            lis.add(sNum);
        }
        return lis;
    }

    static ArrayList<Integer> comb(int num)
    {
        String sNum = Integer.toString(num);
        ArrayList<String> perms = comb(sNum);
        ArrayList<Integer> nPerms = new ArrayList<Integer>();
        for (int n = 0; n < perms.size(); n++)
        {
            nPerms.add(Integer.parseInt(perms.get(n)));
        }
        return nPerms;
    }

}
