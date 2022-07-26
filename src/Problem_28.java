//Number spiral diagonals
public class Problem_28 {
    public static long equation(long x) {
        return 4*(2*x+1)*(2*x+1)-(12*x);
    }
    public static long spiralsum(long width) {
        long sum = 1;
        for (int n = 1; n <= (width+1)/2-1; n++) {
            sum += equation(n);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(spiralsum(1001));
    }
}
