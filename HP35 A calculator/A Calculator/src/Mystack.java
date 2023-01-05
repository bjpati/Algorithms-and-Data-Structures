
public class Mystack {
    private int array[];
    private int maxSize;
    private int top;

    public Mystack(int size){
        maxSize = size;
        array = new int[maxSize];
        top = -1;
    }
    public void push(int value){
        if(top + 1 != maxSize){
            top++;
            array[top] = value;
        }
        else {
            resize(maxSize * 2);
            push(value);
        }
    }
    public int pop() {
      /* if (top == 0) {
            System.out.println("The stack is already empty");
            return array[top--];
        }

        if (top < maxSize / 4) {
            resize(maxSize / 2);
            return pop();

        } else {*/
            int newArray = array[top];
            array[top--] = 0;
            return newArray;

       //}
    }
    private void resize(int newSize) {
        int[] dynamicArray = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            dynamicArray[i] = array[i];
        }
        array = dynamicArray;
        maxSize = newSize;
    }

    public void tostring(){
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

   public static void main(String[] args) {
        Mystack stack = new Mystack(2);
       long t0 = System.nanoTime();
       for (int i = 0; i < 500; i++) {
           stack.push(i);
       }
       long t1 = System.nanoTime();
       System.out.println("resolution: " + (t1 - t0)/1000 + " nanosecounds");

       for (int i = 0; i < 500; i++) {
          stack.pop();
      }
       /* stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();*/

        stack.tostring();
    }
}
