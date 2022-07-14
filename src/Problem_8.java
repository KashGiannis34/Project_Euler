import java.util.Objects;
import java.util.Scanner;

public class Problem_8 {
    public static void main(String[] args) {
        String sNum = new Scanner(Objects.requireNonNull(Problem_8.class.getResourceAsStream("/p08.txt"))).nextLine();
        long max = -1L;
        for (int n = 0; n <= sNum.length()-13; n++)
        {
            long product = prod(sNum.substring(n,n+13));
            if (product > max)
                max = product;
        }
        System.out.println(max);
    }

    static long prod(String sNum)
    {
        long product = 1;
        for (int n = 0; n < sNum.length(); n++)
        {
            product*=Integer.parseInt(sNum.substring(n,n+1));
        }
        return product;
    }
}
