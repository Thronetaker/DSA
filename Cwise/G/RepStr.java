package G;
import java.util.*;

public class RepStr{

    public static int RepestingStr(String s){ //Wrong Appraoch 
        
        int maxLen = -1, len = 1 ;
        for(int i = 1 ; i< s.length(); i++){
           if( s.charAt(i) != s.charAt(i-1)){
            len++;
            maxLen = Math.max(maxLen, len);
           }else{
            len = 0 ;
           }
            
        }

        return maxLen ; 
    }

    public static int RepeatingStrB(String s){
        int h[] = new int[26];

        for(char c :  s.toCharArray()){
            h[c-'a']++;
        }

        for(int i = 0 ; i< s.length() ; i++){
            char c = s.charAt(i);
            if(h[c-'a'] == 1) return i;
        }

        return -1;

    }
    public static void main(String args[]){
        String s = "aadcbbee";
        System.out.println( RepeatingStrB(s));
    }
}