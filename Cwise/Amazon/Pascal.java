import java.util.*;

public class Pascal {
    
    public static void print_pascal(int n){
        int a[][]  = new int[n][n];
        // a[i][j] = a[i-1][j-1] + a[i-1][j]
        for(int i = 0 ; i< n ;i++){
            for(int j = 0 ; j<= i; j++){
                  if( j == 0) a[i][j] =1;
                  else if( i == j ) a[i][j] =1;
                  else a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
           
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0;j <= i ; j++){
                System.out.print(a[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
        print_pascal(5);
    }
}
