//Coin sums
import java.math.BigInteger;

public class Problem_31 {
    public static void main(String[] args) {
        BigInteger count = new BigInteger("1");
        int sum;
        for (int a = 0; a <= 200; a+=100)
        {
            for (int b = 0; b <= 200; b+=50)
            {
                for (int c = 0; c <= 200; c+=20)
                {
                    for (int d = 0; d <= 200; d+=10)
                    {
                        for (int e = 0; e <= 200; e+=5)
                        {
                            for (int f = 0; f <= 200; f+=2)
                            {
                                for (int g = 0; g <= 200; g+=1)
                                {
                                    sum = a+b+c+d+e+f+g;
                                    if (sum == 200)
                                    {
                                        System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"+"+f+"+"+g);
                                        count = count.add(BigInteger.valueOf(1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
