
package j;
public class RemDup {

    public static int rem(int arr[]){
        int n = arr.length ;
        int i=0 , j=1 ;

        while(j < n){
            if( arr[i] < arr[j]){
                int temp = arr[i +1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
            }
                j++;
        }

        return i +1;
    }
    public static void main(String args[]){
        int arr[] = { 1,1,2,2,2,3,3, 4, 5,5};
        System.out.println( " Length : "+ rem(arr));
    }
}