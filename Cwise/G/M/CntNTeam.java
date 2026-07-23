
import java.util.*;

public class CntNTeam {

    public static int CntNT(int arr[]){
        int n = arr.length;
        int ls,lg,rs,rg;
        int ans = 0 ;
        for(int i = 0 ; i<n ; i++ ){
            ls = 0;lg = 0;rs=0;rg=0;
            
            for(int j = 0;j< n ; j++){
                if(i<j){
                    if( arr[i] < arr[j]) rg++;
                    else rs++;
                }else if(i>j){
                    if(arr[i]  < arr[j]) lg++;
                    else ls++;
                }
            }

            ans+= ls*rg + lg*rs;

        }

        return ans;

    }
    public static void main(String args[]){
      int arr[] = {2,5,3,4,1 };
      System.out.println( CntNT(arr));
    }
}
