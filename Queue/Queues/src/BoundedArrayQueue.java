import java.util.NoSuchElementException;

public class BoundedArrayQueue {
    private final int[] elements;
    private int head;
    private int tail;
    private int numberOfElements;

    public BoundedArrayQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be 1 or higher");
        }

        elements = new int[capacity];
    }

    //@Override
    public void add(Integer element) {
        if (numberOfElements == elements.length) {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail] = element;
        tail++;
        if (tail == elements.length) {
            tail = 0;
        }
        numberOfElements++;
    }

    //@Override
    public Integer remove() {
        final Integer element = elementAtHead();
        elements[head] = 0;
        head++;
        if (head == elements.length) {
            head = 0;
        }
        numberOfElements--;
        return element;
    }


    private Integer elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("unchecked")
        Integer element = (Integer) elements[head];

        return element;
    }
    public void print(){
        for (int i = 0; i < numberOfElements; i++)
            System.out.println(elements[i]);
    }
    //@Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public static void main(String[] args) {
        BoundedArrayQueue q = new BoundedArrayQueue(100000000);
        long t0 = System.nanoTime();
        for (int i = 0; i < 100000000; i++)
        {
            q.add(i);
        }
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
        //q.print();
        //9823042 - 6668166
        //15061708 - 16120542
        //24609916 - 108787250
    }
}
