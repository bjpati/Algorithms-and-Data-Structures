public class Queue2 {
    private Node head;
    private Node last;

    public class Node {
        public Integer item;
        public Node tail;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
    }

    public Queue2() {
        head = null;
        last = null;
    }

    public void add(Integer item) {
        long t0 = System.nanoTime();
      Node newNode = last;
      last = new Node(item,head);
      last.item= item;
      last.tail = null;
      if (isEmpty())
          head = last;
      else newNode.tail = last;
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
    }

    public Integer remove() {
        long t0 = System.nanoTime();
        Integer item = head.item;
        head = head.tail;
        if (isEmpty())
            last = null;
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
      return item;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void print(){
        Queue2.Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.item);
            temp = temp.tail;
        }
    }

    public static void main(String[] args) {
        Queue2 q = new Queue2();
        System.out.println("The queue has ");
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        //q.print();
        System.out.println("The queue has");
        q.remove();
        q.remove();
        //q.print();

    }
}
