public class QueueB {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;   // front
    static Node tail = null;   // rear

    // Check if queue is empty
    public static boolean isEmpty() {
        return head == null && tail == null;
    }

    // Add (Enqueue)
    public static void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Remove (Dequeue)
    public static int remove() {
        if (isEmpty()) {
            return -1;
        }

        int front = head.data;

        // If only one element
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }

        return front;
    }

    // Peek (Front element)
    public static int peek() {
        if (isEmpty()) {
            return -1;
        }

        return head.data;
    }

    // Display queue
    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);

        display();

        System.out.println("Front element: " + peek());
        System.out.println("Removed element: " + remove());

        display();
    }
}