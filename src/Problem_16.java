//Power digit sum
import java.math.BigInteger;
public class Problem_16 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("2");
        num = num.pow(1000);
        BigInteger sum = new BigInteger("0");
        char[] numstr = num.toString().toCharArray();
        for (char letter:numstr) {
            sum = sum.add(BigInteger.valueOf(Character.getNumericValue(letter)));
        }
        System.out.println(sum);
    }
}
