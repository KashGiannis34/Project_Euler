public class Problem_33 {
    public static void main(String[] args) {
        for (int a = 10; a < 99; a++)
        {
            for (int b = a+1; b < 99; b++)
            {
                int[] fract = frac(a,b);
                if (fract[0] != -1 && fract[1] != -1)
                {
                    System.out.println(a + "\t" + b);
                }
            }
        }
    }

    static int[] frac(int num, int dem)
    {
        int[] result = new int[2];
        if ((num%10 == 0 && dem%10==0))
        {
            result[0] = result[1] = -1;
            return result;
        }

        String sNum = Integer.toString(num);
        String sDem = Integer.toString(dem);

        for (int n = 0; n < 2; n++)
        {
            for (int d = 0; d < 2; d++)
            {
                if ((((double) Integer.parseInt(sNum.substring(n,n+1))/Integer.parseInt(sDem.substring(d,d+1)))==((double)num/dem))&&(sNum.substring(1-n,2-n).equals(sDem.substring(1-d,2-d))))
                {
                    result[0] = Integer.parseInt(sNum.substring(n,n+1));
                    result[1] = Integer.parseInt(sDem.substring(d,d+1));
                    return result;
                }
            }
        }

        result[0] = result[1] = -1;
        return result;
    }
}
