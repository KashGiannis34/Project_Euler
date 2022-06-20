public class Problem_21 {
    public static int sum(int n) {
        int sum = 1;
        for (int div = 2; div <= Math.sqrt(n); div++) {
            if (n % div == 0) {
                sum += div;
                if ((n / div) != div) {
                    sum += (n / div);
                }
            }
        }
        return sum;
    }
    public static int amicable(int n) {
        return (n == sum(sum(n)) && n != sum(n)) ? n:0;
    }
    public static void main(String[] args) {
        long count = 0;
        for (int n = 1; n < 10000; n++) {
            count += amicable(n);
        }
        System.out.println(count);
    }
}
