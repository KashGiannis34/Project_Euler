//Lexicographic permutations
public class Problem_24 {
    public static int factorial(int num) {
        return (num == 0) ? 1: num * factorial(num-1);
    }
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void shift(int[] array, int index, int newindex) {
        if (index > newindex) {
            for (int n = index; n > newindex; n--) {
                swap(array, n, n-1);
            }
        } else {
            for (int n = index; n < newindex; n++) {
                swap(array, index, index+1);
            }
        }
    }
    public static void permu(int mcombos) {
        int[] perms = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int combos = 1;
        for (int n = 0; n < perms.length - 1; n++) {
            int count = 0;
            while (combos + factorial(9 - n) <= mcombos && count < 9 - n) {
                combos += factorial(9 - n);
                count += 1;
            }
            shift(perms,n + count, n);
        }
        for (int i : perms) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(combos);
    }
    public static void main(String[] args) {
        permu(1000000);
    }

}
