import java.util.Random;

public class MinPQ{

    private class Node {
        private Node head;
        private Node left;
        private Node right;
        private int element;

        Node(int element) {
            this.element = element;
            this.head = null;
            this.right = null;
            this.left = null;
        }
    }

    private Node root; // Keeps track of the top most Node in the tree.
    private Node last; // Keeps track of the most current Node added.
    int numberOfElements = 0;
    private int count;
    private int MSB;


    public MinPQ(){ // Constructor function.
        root = null;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    //-------------------------------Insertion Function O(log(n)) runtime---------------//
    public void insert(int e){
        Node temp = new Node(e);
        if (this.isEmpty()) { // First item is always the root.
            this.root = temp;
        }
        else{
            MSB = 0;
            String binary = java.lang.Integer.toBinaryString(numberOfElements +1);
            insert(root, temp, binary); // This function makes sure the tree is balanced.
        }
        numberOfElements++;
    }

    public void insert(Node x, Node temp, String binary){
        char index = binary.charAt(0);
        int bit = Character.getNumericValue(index);

        if (x.left == null || x.right == null){
            if (x.left == null){
                x.left = temp;
                temp.head = x;
                last = temp;
            }

            else if (x.right == null){
                x.right = temp;
                temp.head = x;
                last = temp;
            }
        }

        else if (bit == 0 && MSB == 0){
            insert(x, temp, binary.substring(1));
        }

        else if (bit == 1 && MSB == 0){
            MSB = MSB + 1;
            insert(x, temp, binary.substring(1));
        }

        else if (bit == 0 && MSB != 0){
            insert(x.left, temp, binary.substring(1));
        }

        else if (bit == 1 && MSB != 0){
            insert(x.right, temp, binary.substring(1));
        }

    }
//--------------------------------------------------------------------------------//


    public void show(){
        String str = "Pre Order Traversal";
        String dashes = "_";
        String star = "*";
        for (int n = 1; n < str.length(); n++) {
            dashes = dashes + "_";
            star = star + "*";
        }
        System.out.println(star);
        System.out.println("Pre Order Traversal");
        System.out.println(dashes);
        System.out.println();
        show(root);
        System.out.println(dashes);
        System.out.println(star);

    }

    public int min(){
        return root.element;
    }

    public int delete(){
        root.element = last.element; // Switches the last node with the first node.
        // Need to delete the last node. The only way to do is to make the pointer of the parent point to null.
        if (last.head.right.element == last.element) {
            last.head.right = null;
        }
        else if (last.head.left.element == last.element) {last.head.left = null;}
        sink(root);
        return root.element;
    }

    public int size(){
        return numberOfElements;
    }


//-----------------------------Helper Functions---------------------------------//


    private void show(Node toShow){ // Just a simple Pre Order Traversal.
        if (toShow == null) return;
        else{
            if (toShow.head != null){
                if (toShow.element == toShow.head.left.element){System.out.println(toShow.element + ": Left Child of " + toShow.head.element);}
                else {System.out.println(toShow.element + ": Right Child of " + toShow.head.element);}
            }
            else {System.out.println(root.element + ": Root");}
            show(toShow.left);
            show(toShow.right);
        }
    }


    public void raise(Node x){ // Recursive function that helps the minimum value move up the tree.
        if (x.head == null) return;
        else if (x.element < x.head.element){
            swap(x, x.head);
            raise(x.head);
        }
    }

    public void sink(Node x){
        if (x.left == null && x.right == null) return;
        else if(x.element < x.left.element && x.element < x.right.element) return;
        else {
            if (x.left.element < x.right.element){
                swap(x, x.left);
                sink(x.left);
            }
            else if (x.left.element > x.right.element){
                swap(x, x.right);
                sink(x.right);
            }
            else if (x.right == null && x.element > x.left.element){
                swap(x, x.left);
                return;
            }
        }
    }


    public void swap(Node x, Node y){ // Swapping function.
        int xTemp = x.element;
        int yTemp = y.element;

        x.element = yTemp;
        y.element = xTemp;
    }

//------------------------------------------------------------------------------//

    public static void main(String[] args) {
        MinPQ heap = new MinPQ();
        int j=new Random().nextInt(100000);
        //long t0 = System.nanoTime();
        for (int n = 0; n <j ; n++) {
            heap.insert(n);
        }
       // long t1 = System.nanoTime();
        //System.out.println(" resolution of insert " + (t1 - t0) + " microseconds");
        //System.out.println(heap.isEmpty());
        long t0 = System.nanoTime();
        heap.delete();
        long t1 = System.nanoTime();
        System.out.println(" resolution of delet " + (t1 - t0) + " microseconds");
        //heap.show();
        //System.out.println(heap.delete());
        //heap.show();

        // Test Cases



    }
}
