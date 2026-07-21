import java.util.*;

public class PofThree {

    public static  boolean PowerOfThree(int n){
        int i = n;
        while(i%3 == 0 ){
            i = i/3;
        }


        if (i ==1 ) return true;
        else return false;
    }

    public static void main( String args[]){
       int n = 100;
       System.out.println(PowerOfThree(n));
       //--------------------shortcut Approach------------------
       System.out.println(Integer.toString(n,3).matches("^10*$"));
    }
    
}
