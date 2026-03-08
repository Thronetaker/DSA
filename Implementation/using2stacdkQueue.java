import java.util.Stack;

public class QueueUsingStacks {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    // Enqueue (Add)
    public static void add(int data) {
        stack1.push(data);
    }

    // Dequeue (Remove)
    public static int remove() {
        if (isEmpty()) {
            return -1;
        }

        // Move elements if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek
    public static int peek() {
        if (isEmpty()) {
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public static boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);

        System.out.println(remove()); // 10
        System.out.println(peek());   // 20
    }
}