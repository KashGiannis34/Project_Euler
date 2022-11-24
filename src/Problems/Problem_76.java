package Problems;

public class Problem_76 {
    public static void main(String[] args) {
        System.out.println(T(100,99));
    }

    static int T(int n, int k)
    {
        if (n == 0 || k == 1)
            return 1;
        else
            return T(n,k-1) + (k>n ? 0:T(n-k,k));
    }
}
