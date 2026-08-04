
// DP 18. Count Partitions With Given Difference
// s1 - s2 = D           => s1 = D + S2 
// s1 + s2 = total      =>      D + S2 + S2 = total    => S2 = (total - D) / 2
public class SumDiff {
    public static  int countPartitions(int arr[], int diff){
        int n = arr.length, total = 0 ;
        for(int i = 0 ; i<n ; i++){
            total+=arr[i];
        }
        
        if( total % 2 != 0 ) return -1;
        int target = (total - diff)/2;

        int dp[][] = new int[n][target + 1];

        if( arr[0] == 0 ) dp[0][0] = 2;     //for sum 0 
        else  dp[0][0] = 1;      //not take 

        if( arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1 ;

        for(int i = 1 ;i < n ;i++){
            for(int sum = 1 ; sum<= target ; sum++){
                int notTaken = dp[i-1][sum];
                int taken = 0 ;
                if( arr[i] <= sum) taken = dp[i-1][sum - arr[i] ];

                dp[i][sum]  = notTaken + taken;
            }
        }

        return dp[n-1][target];
    }

    public static void main(String args[]){


    }
    
}
