//Odd period square roots
import java.util.ArrayList;

public class Problem_64 {
    public static void main(String[] args) {
        int count= 0;
        for (int n = 2; n <= 10000; n++)
        {
            if (Math.pow((int) Math.sqrt(n),2) != n)
            {
                if (period(n) % 2 ==1)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static int period(int num)
    {
        ArrayList<Integer> aSeries = new ArrayList<>();
        ArrayList<String> radicals = new ArrayList<>();
        int sub = (int) Math.sqrt(num);
        int numer = 1;
        while (true)
        {
            int den = (num - sub*sub)/numer;
            String rad = "(sqrt(" + num + ") + " + sub + ") /" + den;
            if (radicals.contains(rad))
                break;
            else
                radicals.add(rad);

            int a = 0;
            while (sub - den >= (int) Math.sqrt(num)*-1)
            {
                sub -= den;
                a++;
            }
            sub = Math.abs(sub);
            aSeries.add(a);
            numer = den;
        }
        return aSeries.size();
    }
}

