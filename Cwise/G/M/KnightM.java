import java.util.*;

public class KnightM{
    

    public static double knightMove(int k , int n , int row ,int col ,int directions[][]){
        double dp[][][] = new double[k+1][n][n];
        dp[0][row][col] = 1.0;

        for(int moves = 1; moves <= k ;moves++){

            for(int i = 0 ; i< n ; i++){
                for(int j = 0 ; j<n ; j++){ 

                    for(int[] dir : directions){
                        int prevI = i - dir[0]; //current pos pe ane ki prob from other cell 
                        int prevJ = j - dir[1];

                        if( prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n){
                            dp[moves][i][j] += dp[moves-1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }

        double tProb = 0.0;
        for(int i = 0 ; i< n ;i++){
            for(int j = 0 ; j< n ; j++){
                tProb += dp[k][i][j];
            }
        }

        return tProb;
    }

    public static void main( String args[]){
        int directions[][] = { { 1,2} , {1,-2}, { -1,2}, { -1,-2} ,
               {2,1}, { 2,-1}, {-2,1}, { -2, -1}};
        System.out.println( knightMove(2, 3, 0, 0, directions));
    }
}
