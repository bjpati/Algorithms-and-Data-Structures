import java.util.Random;
public class task1 {
    public static void main(String[] args) {

        int average = 0;
        int averageresult;
        //int sum = 0;
        // int n = 10;

        System.out.println(access(10000));
        /*Code 1*/
        /*for (int i = 0; i < 10; i++) {
            long n0 = System.nanoTime();
            long n1 = System.nanoTime();
            System.out.println(" resolution " + (n1 - n0) + " nanoseconds");
            average += n1 - n0;
        }
        System.out.println();
        averageresult = average / 10;
        System.out.println(averageresult);*/

        //////////////////////////////////////////////////////////////
        /*Code 2*/
        /*int[] given = {1,2,3,4,5,6,7,8,9,0};
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            long  t0 = System.nanoTime();
            sum += given[i];
            long t1 = System.nanoTime();
            System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
            average += t1 - t0;
        }
        System.out.println();
        averageresult = average / 10;
        System.out.println(averageresult);*/

        /////////////////////////////////////////////////////////////

        /*Code 3*/
        /*int[] given = {1,2,3,4,5,6,7,8,9,0};
        int sum = 45;
        for (int i = 0; i < 10; i++) {
            long  t0 = System.nanoTime();
            long t1 = System.nanoTime();
            System.out.println(" resolution " + (t1 - t0) + " nanoseconds");
            average += t1 - t0;
        }
        System.out.println();
        averageresult = average / 10;
        System.out.println(averageresult);*/

    }

    //Code 4
        //a function that does random access in an array of size n
        // and returns the time it took in nanoseconds to do one operation
        private static double access(int n) {
            int k = 1_000_000;
            int l = n;
            Random rnd = new Random();
            int[] indx = new int[l];
            // fill the indx array with random number from 0 to n (not including n)
            for (int i = 0; i < indx.length; i++)
            {
                indx[i] = rnd.nextInt(n);
            }
            int[] array = new int[n];
            // fill the array with dummy values (why not 1)
            for(int p = 0; p < array.length; p++){
                if (p%2 == 0)
                    array[p] = 0;
                else array[p] = 1;
            }
            int sum = 0;
            long  t0 = System.nanoTime();
            for (int j = 0; j < k; j++) {
                for (int i = 0; i < l; i++) {
            // access the array with the index given by indx[i] // sum up the result
                    sum += array[indx[i]];
                }
            }
            long t_access = (System.nanoTime() - t0);
            t0 = System.nanoTime();
            // do the same loop iteration but only do a dummy add operation long t_dummy = (System.nanoTime() - t0);
            long t_dummy = (System.nanoTime() - t0);
            for (int j = 0; j < k; j++) {
                for (int i = 0; i < l; i++){
                    sum += 0;
                }
            }

            return ((double)(t_access - t_dummy))/((double)k*(double)l);
        }
}


