import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        long t0 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            // for each element from i towards 1, swap the item found with the
            // item before it if it is smaller
            for (int j = i; j > 0 && (array[j] - (array[j - 1]) < 0); j--) {
                swap(array, j, j - 1);
            }
        }
        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0)/1000 + " microseconds");
        /*for (int i = 0; i < array.length; ++i)
            System.out.print(array[i] + " ");*/
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(100);
        }
        insertionSort(array);
    }
}
