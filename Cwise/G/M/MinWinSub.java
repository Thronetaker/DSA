import java.util.*;
public class MinWinSub {

    public static String minWindowSub(String s, String t ){
        int map[] = new int[256];
        int n = s.length(), m = t.length(), sIdx = -1, cnt = 0, l = 0, r=0, minlen= Integer.MAX_VALUE;


        
            for(int j = 0 ; j< m;j++){
                map[t.charAt(j)]++;   
            }
            
            
             
            while( r < n){
                char ch = s.charAt(r);
                if( map[ch] >0 ) cnt++; 
                map[ch]--;

                while (cnt == m ){
                    if( r-l+1 < minlen){
                        minlen = r-l+1;
                        sIdx = l;
                    }
                     map[s.charAt(l)]-- ;
                    if( map[s.charAt(l)] > 0 ) cnt--;
                }
                r++;

            }

            return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minlen);


        
    }
    public static void main( String args[]){
        System.out.println( minWindowSub("ddaaabbca", "abc"));
    }
}
