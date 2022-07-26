//Double-base palindromes

public class Problem_36 {
    public static void main(String[] args) {
        int sum = 0;
        for (int n = 1; n < 1000000; n++)
        {
            if (pal(Integer.toString(n)) && pal(binary(n)))
            {
                sum += n;
            }
        }
        System.out.println(sum);
    }

    static String binary(int num)
    {
        String sNum = "";
        for (int n = (int) (Math.log(num)/Math.log(2)); n >= 0; n--)
        {
            int dig = (int) (num / Math.pow(2,n));
            sNum += Integer.toString(dig);
            num -= Math.pow(2,n)*dig;
        }
        return sNum;
    }

    static boolean pal(String sNum)
    {
        for (int n = 0; n <= sNum.length()/2 - 1; n++)
        {
            if (!(sNum.substring(n , n+1).equals(sNum.substring(sNum.length()-1-n, sNum.length()-n))))
            {
                return false;
            }
        }
        return true;
    }
}
