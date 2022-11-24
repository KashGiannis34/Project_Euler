package Problems;//Maximum path sum II
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem_67 {
    private static ArrayList<Integer>[] tri = triList();
    public static void main(String[] args) {
        for (int a = 98; a >= 0; a--)
        {
            for (int b = 0; b < tri[a].size(); b++)
            {
                tri[a].set(b, Math.max(tri[a].get(b)+tri[a+1].get(b), tri[a].get(b)+tri[a+1].get(b+1)));
            }
        }
        System.out.println(tri[0].get(0));
    }

    static ArrayList<Integer>[] triList()
    {
        int count = 1;
        ArrayList<Integer>[] nums = new ArrayList[100];
        Scanner sc = new Scanner(Objects.requireNonNull(Problem_67.class.getResourceAsStream("/Problems/p067_triangle.txt")));
        while (sc.hasNextLine())
        {
            nums[count-1] = IntStream.of(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));
            count++;
        }
        return nums;
    }
}
