//Smallest multiple
public class Problem_05 {
    public static void main(String[] args) {
        int n = 2;
        while (true)
        {
            if (div20(n))
            {
                System.out.println(n);
                break;
            }
            n++;
        }
    }
    static boolean div20(int num)
    {
        for (int n = 2; n <= 20; n++)
        {
            if (num % n != 0)
            {
                return false;
            }
        }
        return true;
    }
}
