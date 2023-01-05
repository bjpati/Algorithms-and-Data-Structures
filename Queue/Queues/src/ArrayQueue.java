import java.util.NoSuchElementException;

public class ArrayQueue {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    private int[] elements;
    private int head;
    private int tail;
    private int numberOfElements;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be 1 or higher");
        }

        elements = new int[capacity];
    }

    //@Override
    public void add(int element) {
        if (numberOfElements == elements.length) {
            grow();
        }
        elements[tail] = element;
        tail++;
        if (tail == elements.length) {
            tail = 0;
        }
        numberOfElements++;
    }
    //@Override
    public int remove() {
        final int element = elementAtHead();
        elements[head] = 0;
        head++;
        if (head == elements.length) {
            head = 0;
        }
        numberOfElements--;
        return element;
    }
    private int elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("unchecked")
        int element = (int) elements[head];

        return element;
    }
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
    private void grow() {
        int newCapacity = calculateNewCapacity(elements.length);
        growToNewCapacity(newCapacity);
    }

    private int calculateNewCapacity(int currentCapacity) {
        return currentCapacity * 2;
    }

    private void growToNewCapacity(int newCapacity) {
        int[] newArray = new int[newCapacity];
        // Copy to the beginning of the new array: tailIndex to end of the old array
        int oldArrayLength = elements.length;
        int numberOfElementsAfterTail = oldArrayLength - tail;
        System.arraycopy(elements, tail, newArray, 0, numberOfElementsAfterTail);

        // Append to the new array: beginning to tailIndex of the old array
        if (tail > 0) {
            System.arraycopy(elements, 0, newArray, numberOfElementsAfterTail, tail);
        }

        // Adjust head and tail
        head = 0;
        tail = oldArrayLength;
        elements = newArray;
    }
    public void print(){
        for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i]);
    }
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        long t0 = System.nanoTime();
        for (int i = 0; i < 100000000; i++)
        {
            q.add(i);
        }
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
        //q.print();
    }
}
