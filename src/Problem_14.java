public class Problem_14 {
    public static void main(String[] args) {
        int max = -1;
        long maxNum = -1;
        for (long n = 1; n < 1000000; n++)
        {
            int num = chain(n);
            if (num > max) {
                max = num;
                maxNum = n;
            }
        }
        System.out.println(maxNum);
    }

    static int chain(long num)
    {
        int length = 1;
        while (num > 1) {
            if (num % 2 == 1)
            {
                num = num*3+1;
            }
            else
            {
                num /= 2;
            }
            length++;
        }
        return length;
    }
}
