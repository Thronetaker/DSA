import java.util .* ;

public class HeapCheck {
    
    public static int Hpa(int profit[], int k ){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for( int p : profit){
            pq.add(p);
        }

        long totProfit = 0;

        for(int  i = 0 ; i < k ; i++){
            int el = pq.poll();
            totProfit += el;
            pq.add(el-1);
        }

        return (int)totProfit;


    }

    public static void main(String args[]){
        int p[] = { 3,4,6};
        int k =4 ;
        System.out.println( "profit : " + Hpa(p, k));
    }
}
