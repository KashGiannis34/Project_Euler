package Problems;//Largest product in a grid
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Problem_11 {
    public static void main(String[] args) {
        int[][] grid = numgrid(20, 20);
        int max = -1;
        for (int a = 0; a < grid.length; a++)
        {
            for (int b = 0; b < grid[0].length; b++)
            {
                int prod = -1;
                int prod2 = -1;
                int prod3 = -1;
                int prod4 = -1;
                if (b+3 < 20)
                {
                    prod = grid[a][b]*grid[a][b+1]*grid[a][b+2]*grid[a][b+3];
                }

                if (b+3 < 20 && a+3 < 20)
                {
                    prod2 = grid[a][b]*grid[a+1][b+1]*grid[a+2][b+2]*grid[a+3][b+3];
                }

                if (a+3 < 20)
                {
                    prod3 = grid[a][b]*grid[a+1][b]*grid[a+2][b]*grid[a+3][b];
                }

                if (a+3 < 20 && b-3 >= 0)
                {
                    prod4 = grid[a][b]*grid[a+1][b-1]*grid[a+2][b-2]*grid[a+3][b-3];
                }

                prod = Math.max(Math.max(prod, prod4), Math.max(prod2,prod3));
                if (prod > max)
                    max = prod;
            }
        }
        System.out.println(max);
    }

    static int[][] numgrid(int len, int wid)
    {
        int[][] numGrid = new int[len][wid];
        Scanner s = new Scanner(Objects.requireNonNull(Problem_11.class.getResourceAsStream("/Problems/p11.txt")));
        int count = 0;
        while (s.hasNextLine())
        {
            numGrid[count] = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            count++;
        }
        return numGrid;
    }
}
