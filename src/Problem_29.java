//Distinct powers
import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_29 {
    public static void main(String[] args) {
        BigInteger num;
        BigInteger na;
        ArrayList<String> nums = new ArrayList<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                na = BigInteger.valueOf(a);
                num = na.pow(b);
                nums.add(num.toString());
            }
        }
        for (int x = 0; x < nums.size(); x++) {
            for (int y = x+1; y < nums.size(); y++) {
                if (nums.get(y).equals(nums.get(x))) {
                    nums.set(y, "0");
                }
            }
        }
        long count = 0;
        for (String s : nums) {
            if (!s.equals("0")) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
