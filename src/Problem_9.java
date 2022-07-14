public class Problem_9 {
    public static void main(String[] args) {
        for (int a = 1; a < 999; a++)
        {
            for (int b = 1; b < 999; b++)
            {
                if (a+b > 999)
                    break;
                int c = 1000-a-b;
                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                if (min*min + (1000-max-min)*(1000-max-min) == max*max)
                {
                    System.out.println(a*b*c);
                    System.exit(0);
                }
            }
        }
    }
}
