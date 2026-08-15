import java.util.*;

class Solution {
    // Function to find the largest divisble subset
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length; // Size of the array 
        
        Arrays.sort(nums);
        
        List<Integer> ans = new ArrayList<>(); // To store the LDS
        
        int[] dp = new int[n]; // DP array 
        Arrays.fill(dp, 1);
        
        int[] parent = new int[n]; // Array to keep record of the parent
        
        // To store the index of last element in the LDS
        int lastIndex = 0; 
        
        // To store the length of LDS
        int maxLen = 0;
        
        // Computing the DP array 
        for(int i = 0; i < n; i++) {
            parent[i] = i; // Assign the parent to itself
            
            // For each previous index
            for(int prevInd = 0; prevInd < i; prevInd++) {
                
                // If the element at index i can be included in the LDS ending at index j
                if(nums[i] % nums[prevInd] == 0 && dp[i] < dp[prevInd] + 1) {
                    dp[i] = dp[prevInd] + 1; // Update the DP value
                    parent[i] = prevInd; // Store the parent
                }
            }
            // If a longer LDS is found, update the values
            if(dp[i] > maxLen) {
                lastIndex = i;
                maxLen = dp[i];
            }
        }
        // Backtracking
        int i = lastIndex;
        
        // Until we reach an index which is its own parent
        while(parent[i] != i) {
            ans.add(nums[i]); // Add the element at current index
            i = parent[i]; 
        }
        ans.add(nums[i]); // Adding the last element 
        
        // Return the computed result
        return ans;
    }  
}

class Main {
    public static void main(String[] args) {
        int[] nums = {3, 5, 10, 20};
        
        // Creating an object of Solution class
        Solution sol = new Solution();
        List<Integer> ans = sol.largestDivisibleSubset(nums);
        
        System.out.print("The largest divisible subset is: ");
        for(int x : ans) System.out.print(x + " ");
    }
}





// Algorithm
// Sort the input array in ascending order to transform the problem into finding the longest divisible chain.
// Initialize two arrays: dp[i] to store the length of the longest divisible subset ending at index i (initially set to 1), and parent[i] to store the previous element in the optimal subset (initially set to i).
// For each element, check all previous elements. If the current element is divisible by a previous element and forms a longer subset, update dp[i] and parent[i].
// While filling the DP table, keep track of the maximum length and its ending index (lastIndex).
// Backtrack from lastIndex using the parent array until reaching an element whose parent is itself.
// The backtracked elements form the longest divisible subset in correct order, which can be returned as the result.