import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        // Code 5//
        Random rnd = new Random();
        int n = 50000;
        int m = n*2;
        int k = 100;
        //int sum  = 0;
        long t_total = 0;

        int[] keys = new int[m];
// fill the keys array with random number from 0 to 10*n
        for (int i = 0; i < keys.length; i++)
        keys[i] = rnd.nextInt(n*10);

        int[] array = new int[n];
// fill the array with random number from 0 to 10*n
        for (int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt(n*10);

        int sum = 0;
        long  t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                        break; }
                } }
        }
        long t_access = (System.nanoTime() - t0);

        System.out.println(t_access);

        //Code 6//
/*
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < k; j++) {
            // fill the keys array with random number from 0 to 10*n
            for (int i = 0; i < keys.length; i++)
                keys[i] = rnd.nextInt(n*10);
            // fill the array with with random number from 0 to 10*n
            for (int i = 0; i < array.length; i++)
                array[i] = rnd.nextInt(n*10);

            long  t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                        break; }
                } }
            t_total += (System.nanoTime() - t0);

        }*/
       // System.out.println(t_total);
    }
}
