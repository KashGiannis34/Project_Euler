package Problems;

//Champernowne's constant
public class Problem_40 {
    public static void main(String[] args) {
        String sNum = "";
        int count = 1;
        while(sNum.length()<1000000)
        {
            sNum += Integer.toString(count);
            count++;
        }
        System.out.println(sNum.substring(0,11));
        int prod = 1;
        for (int n = 0; n<= 6;n++)
        {
            int num = Integer.parseInt(sNum.substring((int) Math.pow(10, n)-1, (int) (Math.pow(10,n))));
            prod *= num;
            System.out.println("num = " + num);
        }
        System.out.println(prod);
    }
}
