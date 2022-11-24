package Problems;

//Non-abundant sums
public class Problem_23 {
    public static boolean abundant(int n) {
        return (Problem_21.sum(n) > n);
    }
    public static boolean notpaired(int n) {
        for (int val = 1; val < n; val++) {
            if (abundant(val) && abundant(n - val)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        long sum = 0;
        for (int n = 1; n <= 28123; n++) {
            sum += (notpaired(n)) ? n:0;
        }
        System.out.println(sum);
    }
}
