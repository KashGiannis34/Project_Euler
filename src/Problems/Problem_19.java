package Problems;

//Counting Sundays
public class Problem_19 {
    public static boolean leap(int year) {
        return (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0)));
    }
    public static void main(String[] args) {
        Integer[] count = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dow  = 0;
        int scount = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 0; month <= 11; month++) {
                int maxday = count[month];
                if (month == 1) {
                    maxday = (leap(year) == true) ? 29:28;
                }
                for (int day = 1; day <= maxday; day++) {
                    if (day == 1 && dow == 0) {
                        scount += 1;
                    }
                    dow += 1;
                    if (dow > 6) {
                        dow = 0;
                    }
                }
            }
        }
        System.out.println(scount);
    }
}
