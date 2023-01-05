public class Queue1 {
    Node head;
    public class Node {
        public Integer item;
        public Node tail;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
    }
    public Queue1() {
        head = null;
    }

    public void add(Integer item) {
        long t0 = System.nanoTime();
        Node newNode = new Node(item, null);
        if (head == null){
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.tail != null)
            {
                temp = temp.tail;
            }
            temp.tail = newNode;
        }
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
    }
    public Integer remove() {
        long t0 = System.nanoTime();
        Integer item = head.item;
        head = head.tail;
        if (isEmpty())
            head = null;
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
        return item;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void print(){
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.item);
            temp = temp.tail;
        }
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1();
        System.out.println("The queue has ");
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        //q.print();
        System.out.println("The queue has");
        q.remove();
        //q.remove();
        //q.print();
        /*System.out.println("Add to the queue");
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println("Remove first element");
        q.remove();*/
    }

}
