import java.util.Random;

public class BinaryTree {
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        root = add(root, key, value);
    }

    private Node add(Node root, Integer key, Integer value) {
        if (root == null) {
            return new Node(key, value);
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            root.left = add(root.left, key, value);
        } else if (compare > 0) {
            root.right = add(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }


    private void lookup(Integer key) {
        lookup(root, key);
    }

    public static Integer lookup(Node root, Integer key) {
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return lookup(root.left, key);
        } else if (compare > 0) {
            return lookup(root.right, key);
        } else
            return root.value;
    }

    private void print() {
        print(root);
    }

    public void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(" " + "[" + root.key + "," + root.value + "]");
            print(root.right);
        }
    }


    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        /* Let us create following BST
              5
           /     \
          3       7
         /  \    /  \
       2     4  6   8
20
30
40
50
60
70
80*/
        int n = 10000;
        for (int i = 0; i < n; i++) {
            Integer j = new Random().nextInt(100);
            tree.add(i, j);
        }

        long t0 = System.nanoTime();
        System.out.println(lookup(tree.root, 6241));
        long t1 = System.nanoTime();
        System.out.println("\n selection resolution " + (t1 - t0) + " nanoseconds");
        tree.print();
    }
}
