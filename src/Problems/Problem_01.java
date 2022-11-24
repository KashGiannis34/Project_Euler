package Problems;

//Multiples of 3 or 5
public class Problem_01 {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        int[] addArr = {2,1,3,1,2,3,3};
        int num = 3;
        while (num < 1000)
        {
            sum+= num;
            num += addArr[count%7];
            count++;
        }
        System.out.println(sum);
    }
}
