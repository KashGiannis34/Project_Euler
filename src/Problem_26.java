import java.util.ArrayList;
public class Problem_26 {
    public static ArrayList<String> fraction(int a, int b) {
        ArrayList<Integer> prevals = new ArrayList<>();
        ArrayList<String> nums = new ArrayList<>();
        int ta = a;
        nums.add(".");
        outerloop:
        while (true) {
            ta *= 10;
            for (int num = 0; num < prevals.size(); num++) {
                if (prevals.get(num) == ta) {
                    nums.add(num+1, "(");
                    nums.add(")");
                    break outerloop;
                }
            }
            prevals.add(ta);
            while (ta < b) {
                ta *= 10;
                for (int num = 0; num < prevals.size(); num++) {
                    if (prevals.get(num) == ta) {
                        nums.add(num+1, "(");
                        break outerloop;
                    }
                }
                prevals.add(ta);
                nums.add("0");
            }
            nums.add(Integer.toString(ta / b));
            if (ta % b == 0) {
                break;
            }

            ta %= b;
        }
        return nums;
    }
    public static void main(String[] args) {
        int digits, mdigits;
        mdigits = 0;
        int mnum = 0;
        for (int n = 2; n < 1000; n++) {
            digits = 0;
            boolean cdig = false;
            ArrayList<String> nums = fraction(1, n);
            for (String num: nums) {
                if (cdig) {
                    digits += 1;
                }
                if (num.equals("(")) {
                    cdig = true;
                }
            }
            if (digits > mdigits) {
                mdigits = digits;
                mnum = n;
            }
        }
        System.out.println(mnum);
    }
}
