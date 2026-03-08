import java.util.*;

public class StackUsingQueues {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // Push
    public static void push(int data) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        q1.add(data);

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop
    public static int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }

    // Peek
    public static int peek() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println(pop());  // 30
        System.out.println(peek()); // 20
    }
}