class Stack {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;   // Top of stack

    // Check if stack is empty
    public static boolean isEmpty() {
        return head == null;
    }

    // Push operation
    public static void push(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Pop operation
    public static int pop() {
        if (isEmpty()) {
            return -1;
        }

        int top = head.data;
        head = head.next;
        return top;
    }

    // Peek operation
    public static int peek() {
        if (isEmpty()) {
            return -1;
        }

        return head.data;
    }

    // Display stack
    public static void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Main method
    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        display();

        System.out.println("Top element: " + peek());
        System.out.println("Popped element: " + pop());

        display();
    }
}