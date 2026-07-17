import java.util.*;

public class PalTri {

    public static   List<Integer> genRow(int row){
        long ans = 1;
        List<Integer> ansRow  = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1 ; col<row ; col++){
            ans = ans *(row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }

        return ansRow ; 
    }

    public static List<List<Integer>> Tri(int n){
        List<List<Integer>> a =  new ArrayList<>();
        for(int i = 1; i<= n ;i++){
            a.add(genRow(i));
        }
        return a;
    }

    public static void main(String args[]){
           
           List<List<Integer>> l = Tri(5);
           for(int i = 0 ;i< l.size() ; i++){
            System.out.println( l.get(i));
           }
    }
}
