//Convergents of e
import java.math.BigInteger;

public class Problem_65 {
    public static void main(String[] args) {
        System.out.println(digSum(eNum(100).toString()));
    }

    static BigInteger eNum(int conv)
    {
        int count = 1;
        BigInteger num = new BigInteger("2");
        BigInteger prevNum = new BigInteger("1");
        while (true)
        {
            count++;
            BigInteger temp = num;
            if (count % 3 != 0)
            {
                num = prevNum.add(num);
            }
            else
            {
                int multiple = count*2/3;
                num = prevNum.add(num.multiply(BigInteger.valueOf(multiple)));
            }
            prevNum = temp;

            if (count == conv)
                break;
        }
        return num;
    }

    static int digSum(String sNum)
    {
        int sum = 0;
        for (int n = 0; n < sNum.length(); n++)
        {
            sum += Integer.parseInt(sNum.substring(n,n+1));
        }
        return sum;
    }
}
