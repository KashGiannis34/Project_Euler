package Problems;

//Sum square difference
public class Problem_06 {
    public static void main(String[] args) {
        int sumsq = 0;
        for (int n = 1; n <= 100; n++)
        {
            sumsq += n*n;
        }
        int sqsum = (int) Math.pow(50*101,2);
        System.out.println(sqsum-sumsq);
    }
}
