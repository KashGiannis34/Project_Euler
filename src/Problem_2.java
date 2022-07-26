//Even Fibonacci numbers
public class Problem_2 {
    public static void main(String[] args) {
        int fib = 2;
        int prev = 1;
        int sum = 0;
        while (fib < 4000000)
        {
            if (fib%2 == 0)
                sum+=fib;
            int temp = fib;
            fib+= prev;
            prev = temp;
        }
        System.out.println(sum);
    }
}
