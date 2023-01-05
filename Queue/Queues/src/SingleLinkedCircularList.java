public class SingleLinkedCircularList<Type> {
    Node<Type> head;
    Node<Type> tail;
    int len;

    public class Node<Type> {
        Type value;
        Node<Type> next;

        public Node(Type newValue) {
            this.value = newValue;
            this.next = null;
        }
    }

    public void addLast(Type newValue) {
        Node<Type> newNode = new Node(newValue);
        if (len == 0) {
            head = newNode;
            tail = head;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
            tail.next = head;
        }
        len++;
    }

    public Type removeFirst() {
        Type removedValue = head.value;
        if (len == 0) {
            System.out.println("There is nothing to remove.");
        } else {
            head = head.next;
            tail.next = head;
        }
        len--;
        return removedValue;
    }

    public void addFirst(Type newValue) {
        Node<Type> newNode = new Node(newValue);
        if (len == 0) {
            head = newNode;
            tail = head;
            tail.next = head;
        } else {
            newNode.next = tail.next;
            head = newNode;
            tail.next = head;
        }
        len++;
    }

    public Type removeLast() {
        Type removedValue = tail.value;
        if (len == 0) {

        } else if (len == 1) {
            tail = null;
            head = null;
        } else if (len <= 2) {
            tail = head;
        } else {
            Node<Type> temp = head;
            while (temp.next.next != tail) {
                temp = temp.next;
            }
            temp.next.next = head;
            tail.next = null;
            tail = temp.next;

        }
        len--;
        return removedValue;
    }


    public int size() {
        return len;
    }

    public static void main(String[] args) {
        SingleLinkedCircularList<Character> myList2 = new SingleLinkedCircularList<>();

        char[] ch = {'a', 'b', 'c', 'd'};
        for (int i = 0; i < 4; i++) {
            myList2.addLast(ch[i]);
        }

        System.out.println("your current size is: " + myList2.size());
        System.out.println();

        System.out.println("the deleted item will be: " + myList2.removeLast());
        System.out.println("your current size is: " + myList2.size());
        System.out.println();

        System.out.println("the deleted item will be: " + myList2.removeLast());
        System.out.println("your current size is: " + myList2.size());
        System.out.println();

        System.out.println("the deleted item will be: " + myList2.removeLast());
        System.out.println("your current size is: " + myList2.size());
        System.out.println();

        System.out.println("the deleted item will be: " + myList2.removeLast());
        System.out.println("your current size is: " + myList2.size());
        System.out.println();

        /*System.out.println("the deleted item will be: " + myList2.removeLast());
        System.out.println("your current size is: " + myList2.size());
        System.out.println();*/

    }
}
