
import java.util.*;
public class KDiff {
    //   HM TC O(n) O(n)    
    //    TP TC  O(nlogn)  SC o(1)    use when sorted alresdy , then it will not takee nlogn for TC
    public static int KdiffPairs(int arr[], int k){
        int p = 0;

        HashMap<Integer, Integer>  map = new HashMap<>();

        for(int i : arr){
            map.put( i, map.getOrDefault(i, 0) + 1);
        }
       
        for(Integer x : map.keySet()){
            
            if((k==0 && map.get(x) > 1) || (k!= 0 &&map.containsKey(x+k))) {
                p++;
            }
        }

        return p ;
    }

    public static void main(String args[]){
        int arr[] = {3,1,4,1,5};
        System.out.println(KdiffPairs(arr,2));
    }
}
