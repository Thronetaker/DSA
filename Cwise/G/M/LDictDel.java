import java.util.*;

public class LDictDel {

    public static boolean isSubsequence(String s , String d){
        int i = 0, j = 0 ;
        //s  iis big 
        while( i< s.length() && j < d.length()){
            if (s.charAt(i) != d.charAt(j)) i++;
            else {
                i++; j++;
            }
        }

        return j == d.length();
    }

    public static String longDict(String s, List<String> dict){
        String  maxStr ="";
        for( String str : dict){
            if( isSubsequence(s,str)){
                if( str.length() > maxStr.length() || ( str.length() == maxStr.length() && str.compareTo(maxStr) < 0))
                     maxStr = str;
                    System.out.println( "max Str : "+ maxStr);
            }
        }

        return maxStr;
    }
    

    public static void main(String args[]){
       String s = "abcpdvpdvle";
       List<String> dict = List.of("ale", "apple", "monkey", "plea");

        System.out.println( longDict(s,dict ));

    }
}
