import java.util.Random;

public class HeapArray {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int root = 1;

    public HeapArray(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int n) {
        return n / 2;
    }

    private int leftChild(int n) {
        return (2 * n) + 1;
    }

    private int rightChild(int n) {
        return (2 * n) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void bubble(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int sink() {
        int popped = Heap[root];
        Heap[root] = Heap[size--];
        minHeapify(root);
        return popped;
    }

    public static void main(String... arg) {
        System.out.println("The Min Heap is ");
        HeapArray heapArray = new HeapArray(100000);
        /*heapArray.bubble(5);
        heapArray.bubble(3);
        heapArray.bubble(17);
        heapArray.bubble(10);
        heapArray.bubble(84);
        heapArray.bubble(19);
        heapArray.bubble(6);
        heapArray.bubble(22);
        heapArray.bubble(9);
        heapArray.minHeap();*/
        Random rnd = new Random();
        //long t0 = System.nanoTime();
        for (int n = 0; n < 99999; n++) {
            heapArray.bubble(rnd.nextInt(100));
        }
        //long t1 = System.nanoTime();
       // System.out.println(" resolution of insert " + (t1 - t0) + " microseconds");
        //heapArray.print();
        long t0 = System.nanoTime();
        System.out.println("The Min val is " + heapArray.sink());
        long t1 = System.nanoTime();
        System.out.println(" resolution of insert " + (t1 - t0) + " microseconds");
    }
}

