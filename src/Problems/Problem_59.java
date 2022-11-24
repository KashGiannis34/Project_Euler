package Problems;//XOR decryption
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_59 {
    public static void main(String[] args) {
        String sNums = "";
        try {
            File path = new File("D:\\ProjectEuler\\src\\p059_cipher.txt");
            Scanner sc = new Scanner(path);
            while (sc.hasNextLine()) {
                sNums += sc.nextLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String[] nums = sNums.split(",");

        for (int a = 97; a <= 122; a++)
        {
            for (int b = 97; b <= 122; b++)
            {
                for (int c = 97; c <= 122; c++)
                {
                    int[] key = {a,b,c};
                    String text = "";
                    int num = 0;
                    for (int n = 0; n < nums.length; n++)
                    {
                        int ascii = Integer.parseInt(nums[n]) ^ key[n%3];
                        text += (char) (ascii);
                        num += ascii;
                    }
                    if (words(text)) {
                        System.out.println(text);
                        System.out.println(num);
                    }
                }
            }
        }
    }

    static boolean words(String text)
    {
        text = text.toUpperCase();
        return (text.contains("THE") && !text.contains("^") && !text.contains("#") && !text.contains("@"));
    }
}
