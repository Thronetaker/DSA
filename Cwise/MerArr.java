import java.util.*;

public class MerArr {
    public static void mer(int arr1[], int arr2[]){
        int idx = arr1.length -1; // 7
        int m = arr2.length -1; //3
        int n = idx - m -1 ; // 7-3 = 4 -1 = 3

        while( n >= 0 && m >= 0 ){
            if (arr1[n] < arr2[m]){
                arr1[idx] = arr2[m];
                m--;
            }else{
                arr1[idx] = arr1[n];
                n--;
            }
            idx--;
        }

        while( m > 0){
            arr1[idx--] = arr2[m--];
        }
        for(int i =0 ; i<arr1.length ;i++){
            System.out.print(arr1[i]);

        }
        
    }
    public static void main(String args[]){
        int arr1[] = {1,3,5,7,0,0,0,0};
        int arr2[] = {2,6,8,9};
        mer(arr1,arr2);
    }
}
