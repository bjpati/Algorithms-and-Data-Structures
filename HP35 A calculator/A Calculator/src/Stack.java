import java.util.*;

public class Stack {
    private int array[] = new int[1000];
    private int size;
    private int pointer = 0;

    public Stack(){
    }

    public void push(int e){
        if(pointer == 1000){
            throw new StackOverflowError("The stack is full");
        }
        array[pointer++] = e;
    }

    public int pop(){
        if (pointer == 0){
            throw new EmptyStackException();
        }
        int newArray = array[--pointer];
        array[pointer] = 0;
        return newArray;
    }

    public void tostring(){
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
   public static void main(String[] args) {
        Stack stack = new Stack();

        long t0 = System.nanoTime();

        for (int i = 0; i < 200; i++){
        stack.push(i);
        }
     //  stack.push(1);
     //   stack.push(2);
     //   stack.push(3);
      //  stack.push(4);

      long t1 = System.nanoTime();

       // stack.pop();
        //  stack.pop();
        stack.tostring();
       System.out.println("resolution: " + (t1 - t0)/1000 + "nanosecounds");


    }
}
