import java.util.*;

public class MoveZro {
    
    public static void MoveZero(int arr[]){
        int z = arr.length ;
        for( int i = 0 ; i< arr.length ; i++){
            if (arr[i] == 0){
                z=i;
                break;
            }
        }

        for(int i = z+1 ; i< arr.length ;i++){
            if( arr[i] != 0 ){
                int temp = arr[z];
                arr[z] = arr[i];
                arr[i] = temp;
                z++;
            }
        }

        for(int i = 0 ; i< arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] ={0,1,0,3,12 };
        MoveZero(arr);
    }
}
