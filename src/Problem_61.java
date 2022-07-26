//Cyclical figurate numbers
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem_61 {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> nums = set(1000,9999);
        ArrayList<Integer> triNums = triSet(1000, 9999);
        Object[] objArr = nums.keySet().toArray();
        Integer[] numArr = Arrays.copyOf(objArr, objArr.length, Integer[].class);
        Arrays.sort(numArr);

        for (int a = 0; a < numArr.length-4; a++) {
            if (numArr[a] % 100 < 10)
                continue;

            for (int b = 0; b < numArr.length-3; b++)
            {
                if (numArr[b] %100 < 10 || numArr[b] == numArr[a])
                    continue;
                if (numArr[a] % 100 > numArr[b]/100)
                    continue;
                if (numArr[a] % 100 < numArr[b]/100)
                    break;
                for (int c = 0; c < numArr.length-2; c++)
                {
                    if (numArr[c] %100 < 10 || numArr[c] == numArr[a] || numArr[c] == numArr[b])
                        continue;
                    if (numArr[b] % 100 > numArr[c]/100)
                        continue;
                    if (numArr[b] % 100 < numArr[c]/100)
                        break;
                    for (int d = 0; d < numArr.length-1; d++)
                    {
                        if (numArr[d] %100 < 10 || numArr[d] == numArr[a] || numArr[d] == numArr[b] || numArr[d] == numArr[c])
                            continue;
                        if (numArr[c] % 100 > numArr[d]/100)
                            continue;
                        else if (numArr[c] % 100 < numArr[d]/100)
                            break;
                        for (int e = 0; e < numArr.length; e++)
                        {
                            if (numArr[e] %100 < 10 || numArr[e] == numArr[a] || numArr[e] == numArr[b] || numArr[e] == numArr[c] || numArr[e] == numArr[d])
                                continue;
                            if (numArr[d] % 100 > numArr[e]/100)
                                continue;
                            if (numArr[d] % 100 < numArr[e]/100)
                                break;

                            if (nums.keySet().contains((numArr[e]%100*100)+numArr[a]/100))
                            {

                                ArrayList<Integer> nA = nums.get(numArr[a]);
                                ArrayList<Integer> nB = nums.get(numArr[b]);
                                ArrayList<Integer> nC = nums.get(numArr[c]);
                                ArrayList<Integer> nD = nums.get(numArr[d]);
                                ArrayList<Integer> nE = nums.get(numArr[e]);
                                ArrayList<Integer> nF = nums.get((numArr[e]%100*100)+numArr[a]/100);
                                boolean fullCycle = false;
                                for (int numA: nA)
                                {
                                    for (int numB:nB)
                                    {
                                        for (int numC:nC)
                                        {
                                            for (int numD:nD)
                                            {
                                                for (int numE: nE)
                                                {
                                                    for (int numF:nF)
                                                    {
                                                        boolean[] boolList = {false, false, false, false, false, false};
                                                        boolList[numA-3]= true;
                                                        if (boolList[numB-3])
                                                            continue;
                                                        else
                                                            boolList[numB-3] = true;

                                                        if (boolList[numC-3])
                                                            continue;
                                                        else
                                                            boolList[numC-3] = true;

                                                        if (boolList[numD-3])
                                                            continue;
                                                        else
                                                            boolList[numD-3] = true;

                                                        if (boolList[numE-3])
                                                            continue;
                                                        else
                                                            boolList[numE-3] = true;

                                                        if (boolList[numF-3])
                                                            continue;
                                                        else
                                                            fullCycle = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                if (fullCycle) {
                                    System.out.println("(" + numArr[a] + "," + nums.get(numArr[a]) + ")" + " (" + numArr[b] + "," + nums.get(numArr[b]) + ")" + " (" + numArr[c] + "," + nums.get(numArr[c]) + ")" + " (" + numArr[d] + "," + nums.get(numArr[d]) + ")" + " (" + numArr[e] + "," + nums.get(numArr[e]) + ")" + " (" + ((numArr[e] % 100 * 100) + numArr[a] / 100) + "," + nums.get((numArr[e] % 100 * 100) + numArr[a] / 100) + ")");
                                    System.out.println(numArr[a]+numArr[b]+numArr[c]+numArr[d]+numArr[e]+((numArr[e]%100*100)+numArr[a]/100));
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static ArrayList<Integer> triSet(int min, int max)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        int num = 1;
        int step = 2;
        while (num <= max)
        {
            nums.add(num);
            num += step;
            step++;
        }

        ArrayList<Integer> triNums = new ArrayList<>();
        for (int numb: nums)
        {
            if (numb >= min)
            {
                triNums.add(numb);
            }
        }
        return triNums;
    }
    static HashMap<Integer, ArrayList<Integer>> set(int min, int max)
    {
        HashMap<Integer, ArrayList<Integer>> nums = new HashMap<>();
        int count = 3;
        int step = 1;
        int tri = 3;
        while (tri < max)
        {
            int num = tri;
            for (int n = 3; n <= 8; n++)
            {
                int val = tri+step*(n-3);
                if (val <= max && val >= min)
                    nums.computeIfAbsent(val, values -> new ArrayList<>()).add(n);
            }
            step = tri;
            tri += count;
            count++;
        }

        return nums;
    }
}
