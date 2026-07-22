import java.util.*;


public class BeautyArr{

    public static int backtrack(int vis[], int i , int n){
        if(i>n ) return i ;
        int cnt = 0 ;
        for(int x =1 ; x<=n ;x++){
            if(vis[x] == 0 && (x%i == 0 || i%x == 0)){
                vis[x] = 1;
                cnt+= backtrack(vis, i+1, cnt);
                vis[x] = 0;
            }

        }

        return cnt ;
    }
    public static void main( String args[]){
       int n = 2;
       int vis[] =  new int[n+1];

       System.out.println( backtrack( vis, 1,n));
    }
}