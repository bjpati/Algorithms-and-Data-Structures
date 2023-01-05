public class LinkedList1 {
    int head;
    LinkedList1 tail;

    public LinkedList1(int item, LinkedList1 list) {
        head = item;
        tail = list;
    }

    public int head() {
        return this.head;
    }

    public LinkedList1 tail() {
        return this.tail;
    }

    public void append(LinkedList1 b) {
        LinkedList1 nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public static void print(LinkedList1 list) {
        LinkedList1 nxt = list;
        System.out.print(nxt.head() + " ");
        while (nxt.tail != null) {
            nxt = nxt.tail;
            System.out.print(nxt.head() + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList1 myList = new LinkedList1(1, null);
        //System.out.println(myList.head());
        for (int i = 2; i < 100; i++) {
            LinkedList1 temp = new LinkedList1(i, null);
            myList.append(temp);
            //System.out.println("Added new element: " + temp.head());
        }
        print(myList);
    }

}
