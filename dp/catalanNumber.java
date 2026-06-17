import java.util.*;
public class catalanNumber {
    public static int catalanMemoization(int n, int dp[]){
        if(n==0 || n == 1) return 1;
        

        if( dp[n] != -1) {
            return dp[n];
        }
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }
        return ans ;
    }

    public static int catalanRec(int n){
        if(n==0 || n == 1) return 1;

        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }
        return ans ;
    }
    public static void main( String args[]){
        int n = 4 ;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanRec(n));
        System.out.println(catalanMemoization(n,dp));
    }
}