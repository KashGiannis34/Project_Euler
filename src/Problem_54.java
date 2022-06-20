import java.io.*;
import java.util.Scanner;

public class Problem_54 {
    public static void main(String[] args) {
        String[] sDeck = addDeck("D:\\JvProjects\\Project_Euler\\src\\poker.txt",1000);
        int count = 0;
        for (int n = 0; n < sDeck.length; n++)
        {
            if (deckResult(deckToArr(sDeck[n])) == 0)
            {
                System.out.println(sDeck[n]);
                System.out.println(deckResult(deckToArr(sDeck[n])));
                count++;
            }
        }
        System.out.println(count);
    }

    static String[] addDeck(String path, int len)
    {
        String[] deckArr = new String[len];
        try
        {
            File deck = new File(path);
            Scanner sc = new Scanner(deck);
            int count = 0;
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                deckArr[count] = line;
                count++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return deckArr;
    }

    static int[][] deckToArr(String hand)
    {
        int[][] deck = new int[10][2];
        for (int n = 0; n < hand.length(); n++)
        {
            String val = hand.substring(n,n+1);
            if ((n+1)%3==0)
            {
                continue;
            }
            else if ((n+1)%3==1)
            {
                if ("23456789".contains(val))
                {
                    deck[(int) ((n+1)/3)][0] = Integer.parseInt(val);
                }
                else if (val.equals("T"))
                {
                    deck[(int) ((n+1)/3)][0] = 10;
                }
                else if (val.equals("J"))
                {
                    deck[(int) ((n+1)/3)][0] = 11;
                }
                else if (val.equals("Q"))
                {
                    deck[(int) ((n+1)/3)][0] = 12;
                }
                else if (val.equals("K"))
                {
                    deck[(int) ((n+1)/3)][0] = 13;
                }
                else
                {
                    deck[(int) ((n+1)/3)][0] = 14;
                }
            }
            else
            {
                if (val.equals("H"))
                {
                    deck[(int) ((n+1)/3)][1] = 1;
                }
                else if (val.equals("C"))
                {
                    deck[(int) ((n+1)/3)][1] = 2;
                }
                else if (val.equals("S"))
                {
                    deck[(int) ((n+1)/3)][1] = 3;
                }
                else
                {
                    deck[(int) ((n+1)/3)][1] = 4;
                }
            }
        }
        return deck;
    }

    static int deckResult(int[][] deck)
    {
        double[] vals = new double[2];
        for (int d = 0; d < 2; d++)
        {
            double val = 0;
            int[] freq = deckToF(deck,d);
            if (pair4(freq) != -1)
            {
                val += 7 + (double) (pair4(freq))/100;
            }
            else if (pair32(freq) != -1)
            {
                val += 6 + (double) (pair32(freq))/100 + (double) (pair2(freq))/1000;
            }
            else if (pair3(freq) != -1)
            {
                val += 3 + (double) (pair3(freq))/100;
            }
            else if (pair2(freq) != -1)
            {
                val += 2 + (double) (pair2(freq))/100 + (double) (pair22(freq))/1000;
            }
            else if (pair(freq) != -1)
            {
                val += 1 + (double) (pair(freq))/100;
            }

            if (flush(deck, d) != -1)
            {
                val += 5;
            }

            if (arrow(freq) != -1)
            {
                val += 4 + (double) (arrow(freq))/100;
            }

            vals[d] = val;
        }
        if (vals[0] == vals[1])
        {
            return highest(deckToF(deck,0), deckToF(deck,1));
        }
        else
        {
            return (vals[0] > vals[1] ? 0:1);
        }
    }

    static int highest(int[] freq1, int[] freq2)
    {
        double max1 = 0;
        int count = 1;
        for (int n = freq1.length-1; n >=0 ; n--)
        {
            if (freq1[n] == 1)
            {
                max1 += (double) (n)/count;
                count*= 100;
            }
        }

        double max2 = 0;
        count = 1;
        for (int n = freq2.length-1; n >=0 ; n--)
        {
            if (freq2[n] == 1)
            {
                max2 += (double) (n)/count;
                count*= 100;
            }
        }

        return (max1 > max2 ? 0:1);
    }

    static int flush(int[][] deck, int d)
    {
        int s = deck[d*5][1];
        for (int n = (d*5)+1; n < (d*5)+5; n++)
        {
            if (deck[n][1] != s)
            {
                return -1;
            }
        }
        return s;
    }

    static int[] deckToF(int[][] deck, int d)
    {
        int[] freq = new int[15];
        for (int n = 0; n < freq.length; n++)
        {
            freq[n] = 0;
        }

        for (int n = (d*5); n < (d*5)+5; n++)
        {
            freq[deck[n][0]]++;
        }

        return freq;
    }

    static int pair(int[] freq)
    {
        int count = 0;
        int num = -1;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] == 2)
            {
                count++;
                num = n;
            }
        }
        if (count == 1)
        {
            return num;
        }
        else
        {
            return -1;
        }
    }

    static int pair2(int[] freq)
    {
        int count = 0;
        int num = -1;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] == 2)
            {
                count++;
                num = Math.max(n, num);
            }
        }
        if (count == 2)
        {
            return num;
        }
        else
        {
            return -1;
        }
    }

    static int pair22(int[] freq)
    {
        int count = 0;
        int num = 20;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] == 2)
            {
                count++;
                num = Math.min(n, num);
            }
        }
        if (count == 2)
        {
            return num;
        }
        else
        {
            return -1;
        }
    }

    static int pair3(int[] freq)
    {
        int count = 0;
        int num = -1;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] == 3)
            {
                count++;
                num = Math.max(n, num);
            }
        }
        if (count == 1)
        {
            return num;
        }
        else
        {
            return -1;
        }
    }

    static int pair32(int[] freq)
    {
        if (pair(freq) != -1 && pair3(freq) != -1)
        {
            return pair3(freq);
        }
        else
        {
            return -1;
        }
    }

    static int pair4(int[] freq)
    {
        int count = 0;
        int num = -1;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] == 4)
            {
                count++;
                num = n;
            }
        }
        if (count == 1)
        {
            return num;
        }
        else
        {
            return -1;
        }
    }

    static int arrow(int[] freq)
    {
        int count = 0;
        for (int n = 0; n < freq.length; n++)
        {
            if (freq[n] > 1)
            {
                return -1;
            }
            else if (freq[n] == 0 && count != 5 && count != 0)
            {
                return -1;
            }
            else if (freq[n] == 1)
            {
                count++;
            }

            if (count == 5)
            {
                return n;
            }
        }
        return -1;
    }
}
