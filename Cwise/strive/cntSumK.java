import java.util.*;

class cntSumK{

    public int cntWays(int arr[], int target){
        int n = arr.length;
        int dp[][] = new int[n][target+1];

        for(int i = 0 ;i<n ;i++) dp[i][0] = 1;

        if( arr[0] <= target) dp[0][arr[0]] = 1;

        for(int i = 1; i<n ; i++){
            for(int j = 1; j<=target ; j++){

                int notTaken = dp[i-1][j];
                int taken = 0;
                if( arr[i] <= j) taken = dp[i-1][j-arr[i]];

                dp[i][j] = taken + notTaken ;
            }
        }

        return dp[n][target];
    }

    public static void main( String args[]){

    }
}