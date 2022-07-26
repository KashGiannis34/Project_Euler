//1000-digit Fibonacci number

public class Problem_25 {
    public static String sum(String a, String b) {
        int len = Math.max(a.length(), b.length());
        char[] aLetts = new char[len];
        char[] bLetts = new char[len];
        for (int n = 0; n < aLetts.length; n++) {
            aLetts[n] = '0';
            bLetts[n] = '0';
        }
        char[] talet = a.toCharArray();
        char[] balet = b.toCharArray();
        char[] sum = new char[len+1];
        for (int n = 0; n < len + 1; n++) {
            sum[n] = '0';
        }
        for (int n = len-1; n >= len-talet.length; n--) {
            aLetts[n] = talet[talet.length-(len-n)];
        }
        for (int n = len-1; n >= len-balet.length; n--) {
            bLetts[n] = balet[balet.length-(len-n)];
        }
        for (int n = len - 1; n >= 0; n--) {
            int num = Character.getNumericValue(aLetts[n]) + Character.getNumericValue(bLetts[n]);
            if (sum[n+1] == '1') {
                num++;
            }
            if (num >= 10) {
                sum[n] = '1';
            }
            sum[n+1] = (char) ((num % 10) + '0');
        }

        String ans = "";
        if (sum[0] == '0') {
            for (int n = 1; n < sum.length; n++) {
                ans += sum[n];
            }
        } else {
            for (char chara: sum) {
                ans += chara;
            }
        }
        return ans;
    }
    public static String fib(int n) {
        String[] prevnums = {"1", "1"};
        String val = "0";
        int num = 3;
        while (num <= n) {
            val = sum(prevnums[0], prevnums[1]);
            prevnums[0] = prevnums[1];
            prevnums[1] = val;
            num++;
        }
        return val;
    }
    public static void main(String[] args) {
        int digits = 0;
        int index = 10;
        while (true) {
            if (fib(index).length() > digits) {
                digits = fib(index).length();
            }
            if (digits >= 1000) {
                break;
            }
            index++;
        }
        System.out.println(index);
    }
}
