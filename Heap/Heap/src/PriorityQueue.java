import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PriorityQueue {
    private Node head;
    private int totalSize;

    public PriorityQueue() {
        head = null;
        totalSize = 0;
    }

    @Override
    public String toString() {
        String rtn = "";
        if (head == null) {
            rtn = "<Empty>";
        } else {
            Node current = head;
            while (current != null) {
                rtn += "<" + current.getData() + " " + current.getPriority() + "> ";
                current = current.getNext();
            }
        }

        return rtn;
    }

    public void add(String data, int priority) {
        Node ng = new Node();
        ng.setData(data);
        ng.setPriority(priority);

        if (head == null) {
            head = ng;
        } else {
            ng.setNext(head);
            head.setPrev(ng);
            head = ng;
        }

        totalSize++;
    }

    public String remove() {
        if (head == null) {
            return null;
        } else {
            // go through the list and find the last item with the largest priority
            // get the value from the map with the biggest number

            // create an map
            Map<Integer, Node> map = new HashMap<Integer, Node>();
            Node current = head;
            while (current != null) {
                map.put(current.getPriority(), current);
                current = current.getNext();
            }
            // then get all keys in the map,
            Set<Integer> allKeys = map.keySet();

            // find the biggest number
            Integer biggestPriority = Collections.max(allKeys);

            // get the element
            Node target = map.get(biggestPriority);

            // remove the node from the linked list
            if (target.getPrev() == null && target.getNext() == null) {
                // when there is only one node left
                head = null;
            } else if (head == target) {
                head = target.getNext();
                head.setPrev(null);
            } else {
                target.getPrev().setNext(target.getNext()); // connect the target's previous node to the target's next node
                target.getNext().setPrev(target.getPrev());
            }

            totalSize--;
            return target.getData();
        }

    }

    public int size() {
        return totalSize;
    }


    public class Node {
        private String data;
        private int priority;
        private Node next;
        private Node prev;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

        public static void main(String[] args) {

            PriorityQueue pq = new PriorityQueue();
            pq.add("Ginger", 0);
            pq.add("Natalie", 3);
            pq.add("Emanuel", 2);
            pq.add("Gene", 3);
            pq.add("Kay", 2);

            System.out.println(pq);
            System.out.println();
            System.out.println(pq.size());

            System.out.println(pq.remove());
            System.out.println(pq.remove());
            System.out.println(pq.remove());
            System.out.println(pq.remove());
            System.out.println(pq.remove());

            System.out.println(pq);
            System.out.println(pq.size());

        }
}