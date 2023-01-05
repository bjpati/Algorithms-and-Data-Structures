import java.util.Random;

public class LinkedList {
    int head;
    LinkedList tail;
    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }
    public int head() {
        return this.head;
    }
    public LinkedList tail() {
        return this.tail;
    }
    public void append(LinkedList b) {
        long t0 = System.nanoTime();
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
        long t1 = System.nanoTime();
        System.out.println(" resolution: " + (t1 - t0) + " nanoseconds");
    }

    public void append1(LinkedList b) {

        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;

    }
    public static int[] append2(int[] arr1, int[] arr2){
        long t0 = System.nanoTime();
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        while (i < arr1.length)
        {
            arr3[i] = arr1[i];
            i++;
        }
        int pos = arr1.length;
        int j = 0;
        while (pos < arr3.length)
        {
            arr3[pos] = arr2[j];
            j++;
            i++;
        }
        long t1 = System.nanoTime();
        System.out.println(" resolution: " + (t1 - t0) + " nanoseconds");
        return arr3;
    }
    public static void print(LinkedList list){
        LinkedList nxt = list;
        System.out.println(nxt.head() + " ");
        while (nxt.tail != null) {
            nxt = nxt.tail;
            System.out.println(nxt.head() + " ");
        }
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(1) + 1;
            array[i] = nxt;
        }
        return array;
    }


    public void push(int element){
        LinkedList newList = new LinkedList(this.head,this.tail);
        this.head = element;
        this.tail = newList;
    }

    public int pop(){
        int element = this.head;
        this.head = this.tail.head;
        this.tail = this.tail.tail;
        return element;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(0,null);
        //long t0 = System.nanoTime();
        for (int i = 1; i <= 100; i++){
            LinkedList temp = new LinkedList(i,null);
            a.append1(temp);
        }
        //long t1 = System.nanoTime();
        //System.out.println(" resolution: " + (t1 - t0) + " nanoseconds");

        LinkedList b = new LinkedList(101,null);
        for (int i = 102; i <= 100; i++){
            LinkedList temp = new LinkedList(i,null);
            b.append1(temp);
        }
        //long t0 = System.nanoTime();
        a.append(b);
        //long t1 = System.nanoTime();
        //System.out.println(" resolution: " + (t1 - t0) + " nanoseconds");

        //print(a);

        /*int [] a = sorted(200000);
        int [] b = sorted(100);
        int [] c = append2(a,b);*/

        /*LinkedList a = new LinkedList(0,null);
        a.push(1);
        a.push(2);
        print(a);
        System.out.println();
        System.out.println(a.pop());
        System.out.println();

        print(a);*/



    }
}
