import.java.util.*;
// Class containing the subset sum logic
class sumEqualk {
    // Recursive helper with memoization
    public boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If target is achieved
        if (target == 0) return true;

        // Base case: at first index
        if (ind == 0) return arr[0] == target;

        // If already computed
        if (dp[ind][target] != -1) return dp[ind][target] == 1;

        // Choice 1: not take the element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Choice 2: take the element if possible
        boolean taken = false;
        if (arr[ind] <= target) {
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        }

        // Store in DP table (1 for true, 0 for false)
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }

    // Main function to call the helper
    public boolean subsetSumToK(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return subsetSumUtil(n - 1, k, arr, dp);
    }

    
}

// Driver code
public class Main {

    public boolean tabulationApproach( int arr[], int k){ // k = target
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][k+1]; // k+1 as i want idx = k  for storing that sum in it 
        
        dp[0][0] = true;
        for(int i = 1 ; i< n+1 ;i++){  //i is ele in arr
            for(int target = 1 ; target< k+1 ;target++){  // j toward target
                        //    target is greater than before arr ele
                        // // i.e  ofc we should have included before ele , therefore we r now decreasing the target by that value to seach for ans               
                       dp[i][target] = dp[i-1][target] || ( target > arr[i-1] && dp[i-1][target - arr[i-1]]);
            }
        }

        return dp[n][k];

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        sumEqualk sol = new sumEqualk();

        if (sol.subsetSumToK(arr.length, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
