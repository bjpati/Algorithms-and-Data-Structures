import java.util.Random;

public class binarySearch {
    public static boolean binary_search(int[] array, int key) {
        //long t0 = System.nanoTime();
        int first = 0;
        int last = array.length - 1;
        while (true) {
            // jump to the middle
            int index = (last + first) / 2;
            if (array[index] == key) {
                // hmm what now?
                //System.out.println("The key is: " + key);
                //long t1 = System.nanoTime();
                //System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
                return true;
            }
            if (array[index] < key && index < last) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page?
                last = index - 1;
                continue;
            }
            // Why do we land here? What shoudl we do?
            break;

        }
        //System.out.println(" The key you search is not found");
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(1) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static void main(String[] args) {

        int [] array1 = sorted(10000);
        long t0 = System.nanoTime();
        binary_search(array1,99499);
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
        //System.out.println();
        /*int [] array2 = sorted(1000);
        binary_search(array2,50);
        System.out.println();
        int [] array3 = sorted(10000);
        binary_search(array3,50);
        System.out.println();
        int [] array4 = sorted(100000);
        binary_search(array4,50);
        System.out.println();
        int [] array5 = sorted(1000000);
        binary_search(array4,50);*/
    }
}
