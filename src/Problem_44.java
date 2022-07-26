//Pentagon numbers
import java.util.HashMap;

public class Problem_44 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> pents = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> pents2 = new HashMap<Integer,Integer>();
        addPent(pents,100000);
        addPent2(pents2,100000);
        int d = 10000000;

        for (int a = 1; a < pents.size()-1; a++)
        {
            for (int b = a+1; b < pents.size(); b++)
            {
                if (pents.get(pents2.get(b)-pents2.get(a)) != null && pents.get(pents2.get(b)+pents2.get(a)) != null && pents2.get(b)-pents2.get(a) < d)
                {
                     d = pents2.get(b)-pents2.get(a);
                     System.out.println("p"+b+": " + pents2.get(b));
                    System.out.println("p"+a+": " + pents2.get(a));
                     System.out.println(d);
                }
            }
        }

    }

    static int pent(int num)
    {
        return num*(3*num-1)/2;
    }

    static void addPent(HashMap<Integer,Integer> pents, int len)
    {
        for (int n = 1; n <= len; n++)
        {
            pents.put(pent(n),n);
        }
    }
    static void addPent2(HashMap<Integer,Integer> pents, int len)
    {
        for (int n = 1; n <= len; n++)
        {
            pents.put(n,pent(n));
        }
    }
}
