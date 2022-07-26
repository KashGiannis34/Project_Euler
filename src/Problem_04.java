//Largest palindrome product
public class Problem_04 {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        for (int a = 999; a >= 100; a--)
        {
            for (int b = 999; b >= 100; b--)
            {
                if (palin(Integer.toString(a*b)) && a*b > max)
                {
                    max = a*b;
                }
            }
        }
        System.out.println(max);
    }

    static boolean palin(String sNum)
    {
        int max = sNum.length()/2-1;
        if (max % 2 == 0)
            max++;
        for (int n = 0; n < max; n++)
        {
            if (!sNum.substring(n, n+1).equals(sNum.substring(sNum.length()-n-1, sNum.length()-n)))
                return false;
        }
        return true;
    }
}
