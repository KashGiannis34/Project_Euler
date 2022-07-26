//Prime digit replacements
import java.util.ArrayList;

public class Problem_51 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        boolean found8 = false;
        int digits = 1;
        while (found8 == false)
        {
            for (int n = (int) Math.pow(11, digits-1); n <= Math.pow(11,digits)-1; n++)
            {
                nums.clear();
                String sNum = base11(n);
                for (int let = 0; let < sNum.length(); let++)
                {
                    if (sNum.substring(let,let+1).equals("A"))
                    {
                        nums.add(-1);
                    }
                    else
                    {
                        nums.add(Integer.parseInt(sNum.substring(let,let+1)));
                    }
                }
                if (family8(nums))
                {
                    found8 = true;
                    System.out.println(sNum);
                    break;
                }
            }
            digits++;
        }
    }

    static int val(ArrayList<Integer> nums)
    {
        int sum = 0;
        for (int n = 0; n < nums.size(); n++)
        {
            sum += nums.get(n)*Math.pow(10, nums.size()-n-1);
        }
        return sum;
    }

    static boolean prime(int num)
    {
        for (int n = 2; n <= Math.sqrt(num); n++)
        {
            if (num%n == 0)
            {
                return false;
            }
        }
        return true;
    }

    static int family(ArrayList<Integer> nums)
    {
        ArrayList<Integer> empty = new ArrayList<>();
        int count = 0;
        for (int n = 0; n < nums.size(); n++)
        {
            if (nums.get(n) == -1)
            {
                empty.add(n);
            }
        }

        if (empty.size() == 0)
        {
            return -1;
        }

        for (int n = 0; n <= 9; n++)
        {
            if (empty.get(0) == 0 && n == 0)
            {
                    continue;
            }

            for (int e = 0; e < empty.size(); e++)
            {
                nums.set(empty.get(e), n);
            }

            if (prime(val(nums)))
            {
                count++;
            }
        }
        return count;
    }

    static boolean family8(ArrayList<Integer> nums)
    {
        return (family(nums) >= 8);
    }

    static String base11(int num)
    {
        String sNum = "";
        for (int n = (int) (Math.log(num) / Math.log(11)); n >= 0; n--)
        {
            int dig = (int) (num/Math.pow(11,n));
            if (dig < 10)
                sNum += Integer.toString(dig);
            else
                sNum += "A";
            num %= Math.pow(11,n);
        }
        return sNum;
    }
}
