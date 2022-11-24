package Problems;

import java.util.HashMap;

// Singular integer right triangles
public class Problem_75 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> pTriples = new HashMap<>();
        for (int n = 1; n <= 900; n++)
        {
            for (int m = n+1; m <= 900; m++)
            {
                int p = 2*m*m+2*m*n;
                if (p > 1500000)
                    break;
                if (!(m%2 == 0 ^ n%2 == 0)|| !coprime(m,n))
                    continue;
                if (pTriples.containsKey(p))
                {
                    int temp = pTriples.get(p) + 1;
                    pTriples.remove(p);
                    pTriples.put(p, temp);
                }
                else
                {
                    pTriples.put(p, 1);
                }
            }
        }
        HashMap<Integer, Integer> pTriples2 = new HashMap<>();
        for (int key: pTriples.keySet())
        {
            if (pTriples.get(key) == 1)
            {
                pTriples2.put(key,1);
            }
        }

        HashMap<Integer, Integer> triples = new HashMap<>();
        for (int key: pTriples2.keySet()) {
            int n = 1;
            while (key * n <= 1500000)
            {
                int p = key *n;
                if (triples.containsKey(p) && p <= 1500000)
                {
                    int temp = triples.get(p) + 1;
                    triples.remove(p);
                    triples.put(p, temp);
                }
                else
                {
                    if (p <= 1500000)
                        triples.put(p, 1);
                }
                n++;
            }
        }

        int count = 0;
        for (int val: triples.values())
        {
            if (val == 1)
                count++;
        }
        System.out.println(count);
    }

    static boolean coprime(int a, int b)
    {
        while (a!=b)
        {
            int temp = Math.min(a,b);
            a = Math.max(a,b) - temp;
            b = temp;
        }

        return (a==1);
    }
}
