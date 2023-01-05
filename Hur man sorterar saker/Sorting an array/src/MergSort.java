import java.util.Random;

public class MergSort {
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part

        // for all indeces from lo to hi
        for (int k = lo; k <= hi; k++) {
            // if i is greater than mid, move the j item to the org array, update j
            if (i > mid)
                org[k] = aux[j++];
                // else if j is greate than hi, move the i item to the org array, update i
            else if (j > hi)
                org[k] = aux[i++];
                // else if the i item is smaller than the j item, move it to the org array, update i

            else if (less(aux[j], aux[i]))
                org[k] = aux[j++];
                // else you can move the j item to the org array, update j
            else
                org[k] = aux[i++];
        }
    }

    private static boolean less(int aux, int aux1) {
        return aux - (aux1) < 0;
    }

    public static void sort(int[] org) {

        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        long t0 = System.nanoTime();
        sortA(org, aux, 0, org.length - 1);

        long t1 = System.nanoTime();
        System.out.println(" resolution " + (t1 - t0)/1000 + " microseconds");
        /*for (int i = 0; i < org.length; ++i)
            System.out.print(org[i] + " ");*/
    }

    private static void sortA(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            // sort the items from lo to mid
            sortA(org, aux, lo, mid);
            // sort the items from mid+1 to hi
            sortA(org, aux, mid + 1, hi);
            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(100);
        }
        sort(array);
    }
}