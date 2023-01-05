import java.util.Random;

public class evenBetter {

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(3) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static int duplic(int n) {
        int sum = 0;
        int[] keys = sorted(n); //Array with numbers to search
        int[] array = sorted(n); //Array with numbers tex 10, 100, 1000...

        long t0 = System.nanoTime();
        for (int ki = 0; ki < keys.length; ki++) {
            for (int i = 0; i < array.length; i++) {
                if (array[ki] == keys[i]) {
                    sum++;
                }
            }
        }
        long t1 = (System.nanoTime() - t0)/1000;
        System.out.println("resolution: " + t1 + " nanosecond");
        return sum;
    }

    public static int duplicBS(int n) {
        int[] arr = sorted(n);
        int[] arr2 = sorted(n);
        int sum = 0;
        long t0 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (binarySearch.binary_search(arr2, arr[i])) {
                sum++;
            }
        }
        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0)/1000 + " nanoseconds");
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("antal duplic: " + duplic(10));
        System.out.println("antal duplic: " + duplic(100));
        System.out.println("antal duplic: " + duplic(1000));
        System.out.println("antal duplic: " + duplic(10000));
        System.out.println("antal duplic: " + duplic(100000));
        System.out.println();
        System.out.println("antal duplic: " + duplicBS(10));
        System.out.println("antal duplic: " + duplicBS(100));
        System.out.println("antal duplic: " + duplicBS(1000));
        System.out.println("antal duplic: " + duplicBS(10000));
        System.out.println("antal duplic: " + duplicBS(100000));

    }
}

