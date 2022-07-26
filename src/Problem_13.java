//Large sum
import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Problem_13 {
    public static void main(String[] args) {
        BigInteger bigNum = new BigInteger("0");
        BigInteger[] numArr = nums();
        for (BigInteger num: numArr)
        {
            bigNum = bigNum.add(num);
        }
        System.out.println(bigNum.toString().substring(0,10));
    }

    static BigInteger[] nums()
    {
        BigInteger[] numArr = new BigInteger[100];
        Scanner s = new Scanner(Objects.requireNonNull(Problem_13.class.getResourceAsStream("/p13.txt")));
        int count = 0;
        while (s.hasNextLine())
        {
            numArr[count] = new BigInteger(s.nextLine());
            count++;
        }
        return numArr;
    }
}
