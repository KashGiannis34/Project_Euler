import java.util.ArrayList;

public class Problem_32 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int count=0;
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int a = 1; a < 10; a++)
        {
            for (int b = 1; b < 10; b++)
            {
                if (b==a)
                {
                    continue;
                }
                for (int c = 1; c < 10; c++)
                {
                    if (b==c || a==c)
                    {
                        continue;
                    }
                    for (int d = 1; d < 10; d++)
                    {
                        if (b==d || a==d || c == d)
                        {
                            continue;
                        }
                        for (int e = 1; e < 10; e++)
                        {
                            if (b==e || a==e || c == e || d==e)
                            {
                                continue;
                            }
                            for (int f = 1; f < 10; f++)
                            {
                                if (b==f || a==f || c==f || d==f || e==f)
                                {
                                    continue;
                                }
                                for (int g = 1; g < 10; g++)
                                {
                                    if (b==g || a==g || c==g || d==g || e==g || f==g)
                                    {
                                        continue;
                                    }
                                    for (int h = 1; h < 10; h++)
                                    {
                                        if (b==h || a==h || c==h || d==h || e==h || f==h || g==h)
                                        {
                                            continue;
                                        }
                                        for (int i = 1; i < 10; i++)
                                        {
                                            if (b==i || a==i || c==i || d==i || e==i || f==i || g==i || h==i)
                                            {
                                                continue;
                                            }
                                            nums[1] = a;
                                            nums[2] = b;
                                            nums[3] = c;
                                            nums[4] = d;
                                            nums[5] = e;
                                            nums[6] = f;
                                            nums[7] = g;
                                            nums[8] = h;
                                            nums[9] = i;
                                            for (int x = 1; x <= 7; x++)
                                            {
                                                for (int eq = x+1; eq <= 8; eq++)
                                                {
                                                    String o1 = "";
                                                    String o2 = "";
                                                    String pd = "";
                                                    for (int n = 1; n <= x; n++)
                                                    {
                                                        o1 += Integer.toString(nums[n]);
                                                    }
                                                    for (int n = x+1; n <= eq; n++)
                                                    {
                                                        o2 += Integer.toString(nums[n]);
                                                    }
                                                    for (int n = eq+1; n <= 9; n++)
                                                    {
                                                        pd += Integer.toString(nums[n]);
                                                    }
                                                    if (Integer.parseInt(o1) * Integer.parseInt(o2) == Integer.parseInt(pd))
                                                    {
                                                        boolean dup = false;
                                                        for (int s = 0; s < results.size(); s++) {
                                                            if (results.get(s) == Integer.parseInt(pd))
                                                            {
                                                                dup = true;
                                                            }
                                                        }
                                                        if (!dup)
                                                        {
                                                            count += Integer.parseInt(pd);
                                                            System.out.println(o1 + "x" + o2 + "=" + pd);
                                                            results.add(Integer.parseInt(pd));
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
