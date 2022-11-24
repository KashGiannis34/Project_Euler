package Problems;

//Number letter counts
public class Problem_17 {
    public static void main(String[] args) {
        String[] firstwords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "and"};
        String[] nextwords = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] finalwords = {"zero","ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"};
        int megaword = 0;
        for (int n = 1; n <= 1000; n++) {
            int num = n;
            int word = 0;
            while (num != 0) {
                if (num <= 10) {
                    word += firstwords[num].length();
                    num = 0;
                } else if (num <= 19) {
                    word += nextwords[num % 10].length();
                    num = 0;
                } else if (num < 100) {
                    word += finalwords[(num - num%10)/10].length();
                    num %= 10;
                } else if (num == 1000) {
                    word += 11;
                    num = 0;
                } else {
                    word += firstwords[num/100].length();
                    word += finalwords[10].length();
                    word += (num % 100 != 0) ? firstwords[11].length():0;
                    num %= 100;
                }
            }
            megaword += word;
        }
        System.out.println(megaword);
    }
}
