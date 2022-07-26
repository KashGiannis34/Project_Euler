//Integer right triangles
import java.util.ArrayList;
public class Problem_39 {
    public static void main(String[] args) {
        ArrayList<Integer> peris = new ArrayList<Integer>();
        for (int a = 3; a <= 333; a++)
        {
            for (int b = a+1; b <= 997;b++)
            {
                if (a+b+b+1 > 1000)
                {
                    break;
                }
                for (int c = b+1; c < a+b;c++)
                {
                    if (a+b+c > 1000)
                    {
                        break;
                    }

                    if (a*a + b*b == c*c)
                    {
                        peris.add(a+b+c);
                    }
                }
            }

        }
        int[] nums = new int[1001];
        for (int n = 0; n < nums.length; n++)
        {
            nums[n] = 0;
        }
        for (int n = 0; n <peris.size(); n++)
        {
            nums[peris.get(n)]++;
        }
        int max= 0;
        int peri = 0;
        for (int n = 0; n < nums.length; n++)
        {
            if (nums[n] > max)
            {
                max = nums[n];
                peri = n;

            }
        }

        System.out.println(peri);

    }


}
