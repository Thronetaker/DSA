

import java.util.*;

public class RecArea {
    
     public static void main( String args[]){
        Scanner sc = new Scanner(System.in);
       int n = 2;
       int points [][] =  new int[n][2];
       for(int i = 0 ; i< n ; i++){
        points[i][0] = sc.nextInt();
       }

       Map<Integer, Set<Integer>> map = new HashMap<>();
       
       for( int [] p : points){
        if( !map.containsKey( p[0])){
            map.put( p[0], new HashSet<>());  //map.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }
        map.get( p[0]).add( p[1]);
       }
        
       int a  = Integer.MAX_VALUE;
       boolean b = false;
       for(int i = 0 ; i< n;i++){
        for(int j = i+1; j<n ;j++){
            if( points[i][0] == points[j][0] ||  points[i][1]== points[j][1]) continue ;
            if( map.get( points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][0])){
                b = true;
                a = Math.min(a, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
            }
        }
       }

       if(b )
       {
        System.out.println( a);
       }else{
        System.out.println("0");
       }
    }
}
