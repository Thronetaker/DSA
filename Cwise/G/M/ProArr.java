import java.util.*;


public class ProArr{
    
    public static int[] productExceptSelf(int arr[]){
        int n = arr.length;
        int ans[] = new int[n];
         Arrays.fill(ans,1);
        int suffix = 1;
        System.out.print("Prefix Pro: " + ans[0] + " ");
        for(int i = 1;i< arr.length ; i++){
            ans[i] = ans[i-1] * arr[i-1];
            System.out.print(  ans[i] + " ");
        }
        
        System.out.println();
        System.out.print("Final Pro: " + ans[n-1] + " ");
        for(int i = n-2 ; i>=0 ; i--){
            suffix *= arr[i+1];
            ans[i] = ans[i] * suffix;
            System.out.print(  ans[i] + " ");
        }
       
        return ans;
    }
    public static void main(String args[]){
        int arr[] ={ 1,2,3,4};
        int ans[] = productExceptSelf( arr);
        System.out.println();
        for(int i = 0 ;i < arr.length; i++){
            System.out.print( ans[i] +" ");
        }
    }
}