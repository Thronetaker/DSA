import java.util.*;

public class InterLL{

     static class  Node{
        int val;
        Node next ;

       Node(int x ){
         this.val = x;
         this.next = null;
       }
    }
    
    public static Node createLL(int arr[]){
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node p = head;
        for(int i =1;i<arr.length ;i++){
            p.next = new Node(arr[i]);
            p = p.next;
        }
        return head;
    }

    public static void printLL( Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val );
            if(temp.next != null) System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void intersectionLL(Node h1,Node h2){
        Node p1 = h1, p2 = h2;
        while(p1!=null || p2!=null){
            if( p1 == null) p1 = h2;
            else if( p2 == null) p2 = h1;

            if (p1.val == p2.val) {
                System.out.println(" intersection : " + p1.val);
                return;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

    public static Node intersectionLLSir(Node h1,Node h2){
        if (h1 == null || h2 == null)return null;
        Node p1 = h1, p2 = h2;
        while(p1!=p2){
             p1 = p1 == null ?  h2 : p1.next;
            p2 = p2== null ?  h1 : p2.next;     
        }
        return p1;
    }
    public static void main(String args[]){
       int l1[] = {1,2,3,4};
       int l2[] = {5,3,4};

       Node h1 = createLL(l1);
       Node h2 = createLL(l2);
       printLL(h1);
       printLL(h2);
       Node inter = intersectionLLSir(h1, h2);
      if (inter != null) {
       System.out.println(" intersection : " + inter.val);
   } else {
       System.out.println("No intersection");
   }
    }

}