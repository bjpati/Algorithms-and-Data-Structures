import java.util.Random;

public class sorted {
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
        return array;

    }

    public static void main(String[] args) {
        sorted(4);
    }
}
