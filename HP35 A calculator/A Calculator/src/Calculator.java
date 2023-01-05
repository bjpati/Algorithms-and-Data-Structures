import java.util.*;

public class Calculator {
    Item[] expr;
    int ip;
    Mystack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Mystack(5);
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.getType()) {
            case ADD: {
                //System.out.println(expr[ip].getValue());
                stack.push(expr[ip++].getValue());
                stack.push(expr[ip++].getValue());
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: {
                stack.push(expr[ip++].getValue());
                stack.push(expr[ip++].getValue());
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL: {
                stack.push(expr[ip++].getValue());
                stack.push(expr[ip++].getValue());
                int y = stack.pop();
                int x = stack.pop();
                if ((x * y) < 10)
                    stack.push(x * y);
                else
                    stack.push(((x * y) % 10) + 1);
                break;
            }
            case DIV: {
                stack.push(expr[ip++].getValue());
                stack.push(expr[ip++].getValue());
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case MOD: {
                stack.push(expr[ip++].getValue());
                stack.push(expr[ip++].getValue());
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x % y);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int count = 0;
        int[] ninePersn = {9, 7, 0, 9, 2, 2, 8, 3, 9};
        for (int i = 0; i < ninePersn.length; i++) {
            int cheak = 0;
            if (count == 0) {
                cheak = 2;
                count = 1;
            } else {
                cheak = 1;
                count = 0;
            }

            Item item1 = new Item(0, ItemType.MUL);
            Item item2 = new Item(ninePersn[i], ItemType.VALUE);
            Item item3 = new Item(2, ItemType.VALUE);

            Item arr[] = {item1, item2, item3};
            Calculator cal = new Calculator(arr);
            ninePersn[i + 1] = cal.run();
        }
        int sum = 0;
        for (int i = 0; i < ninePersn.length - 1; i++) {
            Item item = new Item(0, ItemType.ADD);
            Item item1 = new Item(ninePersn[i], ItemType.VALUE);
            Item item2 = new Item(ninePersn[i + 1], ItemType.VALUE);
            Item[] arrayCalculator = {item, item1, item2};
            Calculator calculator = new Calculator(arrayCalculator);
            ninePersn[i + 1] = calculator.run();
        }
        sum = ninePersn[ninePersn.length - 1];

        Item item = new Item(0, ItemType.MOD);
        Item item1 = new Item(sum, ItemType.VALUE);
        Item item2 = new Item(10, ItemType.VALUE);
        Item[] arrayCalculator = {item, item1, item2};
        Calculator calculator = new Calculator(arrayCalculator);
        sum = calculator.run();


        item = new Item(0, ItemType.SUB);
        item1 = new Item(10, ItemType.VALUE);
        item2 = new Item(sum, ItemType.VALUE);
        Item[] arrayCalculator1 = {item, item1, item2};
        calculator = new Calculator(arrayCalculator1);
        sum = calculator.run();
        System.out.println(sum);
    }
}



















