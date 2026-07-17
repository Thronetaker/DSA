import java.util.*;

class subarray {
    public static void subarraySum(int arr[]){
        int n = arr.length;
        for(int i = 0 ;i<n ; i++){
            for(int j = i+1; j<n ;j++){
                for(int k = i; k<j ;k++){
                    System.out.print(k + " ");
                }
            }
        }
    }
    public static void main( String args[]){
        int arr[]  ={ 1,2,3,1,1,1,1,4,2,3};
        subarraySum(arr);
    }
}
