import java.util.ArrayList;
import java.util.Arrays;
public class Problem_27 {
    public static long quad(long x1, long c, int x) {
        return (long) x * x + x1 * x + c;
    }

    public static boolean prime(long n) {
        if (n < 0) {
            return false;
        }
        for (long div = 2; div <= (long) Math.sqrt(n); div++) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }

    public static long[] primes1000() {
        ArrayList<Long> nums = new ArrayList<>();
        nums.add(2L);
        for (long n = 3; n <= 1000; n++) {
            if (prime(n)) {
                nums.add(n);
            }
        }
        long[] ans = new long[nums.size()];
        for (int num = 0; num < ans.length; num++) {
            ans[num] = nums.get(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int mstreak = 0;
        long mx1 = 0;
        long mc = 0;
        long[] primes = primes1000();
        for (long x1 = -999; x1 < 1000; x1++) {
            for (long c : primes) {
                int streak = 0;
                long val = quad(x1, c, streak);
                while (prime(val)) {
                    streak += 1;
                    val = quad(x1, c, streak);
                }
                if (streak > mstreak) {
                    mstreak = streak;
                    mx1 = x1;
                    mc = c;
                }
            }
        }
        System.out.println(mx1 + " " + mc);
    }
}