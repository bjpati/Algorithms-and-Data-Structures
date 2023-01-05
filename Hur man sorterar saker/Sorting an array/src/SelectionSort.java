import java.util.Random;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        long t0 = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i + 1; j < array.length; j++) {
            // If the element at position j is smaller than the value
            // at the candidate position - then you have a new candidate
            // posistion.
                if (array[j] < array[cand])
                {
                    cand = j;
                }
            }
            // Swap the item at position i with the item at the candidate position.
            int temp = array[cand];
            array[cand] = array[i];
            array[i] = temp;
        }
        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
        /*for (int i=0; i< array.length; ++i)
            System.out.print(array[i]+" ");*/
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] =  rnd.nextInt(100);
        }
        selectionSort(array);
    }
}
