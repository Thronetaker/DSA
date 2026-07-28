import java.util.*;



public class PartLst {
    static class Node{
        int n ;
        Node next;
        Node(int n){
            this.n = n ;
            this.next = null;
        }

        static void printL(Node head){
            Node temp = head;
            while(temp!=null){
                System.out.print( temp.n + "-> ");
                temp = temp.next;
            }
        }
    }

    public static Node partingList(Node head, int x){
        Node temp = head;
        Node before_h = new Node(0), before = before_h ;
        Node after_h = new Node(0), after = after_h ;
        while( temp!= null){
            if(temp.n < x ){
                before.next = temp;
                before = before.next;
            }else if( temp.n >= x){
                after.next = temp ;
                after = after.next;
            }
            temp = temp.next;
        }
        after.next = null;
        before.next = after_h.next;
        return before_h.next;

    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next=new Node(3);
        head.next.next.next = new Node(2) ;
        head.next.next.next.next = new Node(5) ;
        head.next.next.next.next.next = new Node(2) ;
        head.next.next.next.next.next.next = null ;



        head = partingList(head, 3);
        head.printL(head);
    }
}
