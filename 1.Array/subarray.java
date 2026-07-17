import java.util.*;

public class subarray {
    public static int subarraySumBrute(int arr[], int s){
        int n = arr.length;
        int sum = 0, maxlen = 0 , len= 0;
        for(int i = 0 ;i<n ; i++){
            for(int j = i; j<n ;j++){
                for(int k = i; k<=j ;k++){
                    sum+=arr[k];
                }
                System.out.print( sum + " ");
                if( sum == s){
                    len = j-i+1;
                    
                    maxlen = Math.max(len, maxlen);
                    System.out.print("len "+len +"maxlen "+maxlen);
                }
                sum = 0 ;
            }
            System.out.println();
        }
        return maxlen;
    }

    public static int  subarraySumBetter(int arr[], int k){//Hashing
        HashMap<Long, Integer> map = new HashMap<>();
        int n = arr.length , maxlen = 0;
        long  sum = 0;
        for(int i = 0 ; i < n ;i++) {
            sum+=arr[i];

            //base Case exact 
            if( sum ==  k ){
                maxlen = Math.max(maxlen, i+1);
            }
            
            // Complementary check 
            if( map.containsKey( sum - k)){
                int len = i - map.get(sum-k);
                maxlen = Math.max(maxlen, len);

            }

            if(!map.containsKey(sum)){
                map.put(sum ,i);
            }
        }
        return maxlen;
        

    }
    public static void main( String args[]){
        int arr[]  ={ 1,2,3,1,1,1,1,4,2,3};
        System.out.println("ANS : " + subarraySumBetter(arr, 7));
    }
}
