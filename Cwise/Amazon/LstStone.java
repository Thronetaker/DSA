import java.util.*;

public class LstStone {
    public static int lastStoneWgt(int arr[]){
        PriorityQueue<Integer>  maxheap = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int n  : arr){
            maxheap.add(n);
        }

        while(!maxheap.isEmpty()){
            if( maxheap.size() == 1) return maxheap.poll();
            int n1 = maxheap.poll();
            int n2 = maxheap.poll();
            System.out.println( "n1 : "+ n1+" n2 : "+n2 );
            if( n1!=n2){
                  maxheap.add(n1-n2);
            }
            
        }
        return 0 ;

    }
    
    public static void main(String args[]){
       int arr[] = {2,7,4,1,8,1};
       System.out.println(lastStoneWgt(arr));
    }
}
