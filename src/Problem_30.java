//Digit fifth powers
public class Problem_30 {
    public static long sum5(long x) {
        long sum = 0;
        char[] nums = Long.toString(x).toCharArray();
        for (char num: nums) {
            sum += (long) Math.pow(Character.getNumericValue(num), 5);
        }
        return sum;
    }
    public static void main(String[] args) {
        long sum = 0;
        int x = 2;
        while (true) {
            if (sum5(x) == x) {
                sum+= x;
            }
            x += 1;
            System.out.println(sum + "   " + x);
        }

    }
}
