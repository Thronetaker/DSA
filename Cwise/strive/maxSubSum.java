public class maxSubSum {
    // Maximum sum of non adjacent elements

    public static int  maxAdjSum(int arr[]){
        int n = arr.length;
        int dp[] =  new int[n];

        //base case : only one element 
        dp[0] = arr[0];
        //base case : only two element 
        dp[1] = Math.max( arr[0], arr[1]);

        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
            // curr include  , curr not include

        }


        return dp[n-1];

    }

    public static void main(String args[]){
        int arr[] = {2,1,4,9};
        System.out.println(maxAdjSum(arr));
    }
    
}
