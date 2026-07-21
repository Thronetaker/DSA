package j;
import java.util.*;

public class RepAndMis{
    public static void RepetingAndMissingBetter(int arr[], int n ){
        //x = repe  y = miss
        long s = 0,fs = 0, fsq = 0 ,sq = 0;
        for( int i : arr){
            System.out.println("i : "+i);
            s += i;
            sq += (long) i*i;
        }
        
        fs = (n* (n+1)) /2;
        fsq  = (n* (n+1) * ((2*n)+1)) /6;

        long sub = s - fs;
        long addn = (sq - fsq)/sub;
        long x = (sub +addn) /2;
        long y =  x - sub;
         System.out.println("Repeating : " + x);
        System.out.println("Missing : " + y);
        
    }

    public static void RepetingAndMissingB(int arr[], int n ){
        //x = repe  y = miss
        int xor = 0;

        for(int i = 0; i< n ;i++){
            
        }
        
        System.out.println("Repeating : " + "x");
        System.out.println("Missing : " + "y");
        
    }



    public static void RepetingAndMissing(int arr[], int n ){
        int hash[] = new int[n+1];
        int rep = -1, mis =-1;

        for( int i  : arr){
            hash[i]++;
        }
        for( int i = 1 ; i< hash.length ; i++){
            if(hash[i] == 0){
                mis = i;
            }else if(hash[i] > 1){
                rep = i ;
            }

            if(rep != -1 && mis != -1) break;
        }

        System.out.println("Repeating : " + rep);
        System.out.println("Missing : " + mis);

        
    }

    public static void main( String args[]){
        int arr[] = {4,3,6,2,1,1 };
        RepetingAndMissingBetter(arr, arr.length);
    }
}