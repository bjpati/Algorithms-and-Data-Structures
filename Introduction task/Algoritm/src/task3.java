import java.util.Random;

public class task3 {
    public static void main(String[] args) {

        Random rnd = new Random();
        int n = 50000;
        int m = n;
        int k = 100;
        int sum = 0;
        long t_total = 0;

        int[] keys = new int[m]; //Array with numbers to search
        int[] array = new int[n]; //Array with numbers tex 10, 100, 1000...
        for (int j = 0; j < k; j++) {
            // fill the keys array with random number from 0 to 10*n
            for (int i = 0; i < keys.length; i++)
                keys[i] = rnd.nextInt(n * 10);
            // fill the array with with random number from 0 to 10*n
            for (int i = 0; i < array.length; i++)
                array[i] = rnd.nextInt(n * 10);

            int cheak = 0;
            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n; i++) {
                    if (array[i] == key) {
                        sum++;
                        cheak++;
                    }
                    if (cheak == 2)
                    {
                        cheak = 0;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        System.out.println("resolution: " + t_total);
    }
}
