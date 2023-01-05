import java.util.Random;

public class Test {
    public static void main(String[] args){
        Random rnd = new Random();
        int n = 10;
        int[] indx = new int[n];
        for (int i = 0; i < n; i++)
        {
            indx[i] = rnd.nextInt(n);
            System.out.println(indx[i]);
        }

    }
}
