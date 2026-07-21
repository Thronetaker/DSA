import java.util.*;

public class PivotE {

    public static int pivotEle(int arr[]){
        int rs = 0, ls = 0, ts= 0;
        for(int i : arr){
            rs+= i;
        }
        System.out.println( "total : "+ rs);

        for(int i = 0; i< arr.length ; i++){
             ls = i-1 >=0 ? ( ls + arr[i-1]) : 0;
             rs = rs - arr[i];
             System.out.println( "LS : " + ls + " RS : " + rs);;

             if ( ls == rs) return i;
             
        }
        return -1;
    }
    
    public static void main( String args[]){
        int arr[] = {1,7,3,6,5,6 };
        System.out.println( pivotEle(arr));
    }
}
