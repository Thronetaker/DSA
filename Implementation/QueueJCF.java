import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingTwoStacks {

    private Deque<Integer> s1 = new ArrayDeque<>();
    private Deque<Integer> s2 = new ArrayDeque<>();

    // Enqueue
    public void add(int data) {
        s1.push(data);
    }

    // Dequeue
    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(q.remove()); // 10
        System.out.println(q.peek());   // 20
    }
}