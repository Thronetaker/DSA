package Cwise.G.M;

import java.util.HashMap;

public class GStation {
    public static String GasStation(int num, int deno){
        if( num == 0 ) return "0";

        StringBuilder res = new StringBuilder();

        res.append(( ( num > 0) ^ ( deno > 0 )) ? ".":"");
        long n = Math.abs((long) num);
        long d = Math.abs((long) deno);

        res.append(n/d);
        n %= d;
        if( n== 0){
            return res.toString();
        }
        
        //fractional art 
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(n, res.length());
        while( n !=0){
            n *= 10;
            res.append(n/d);
            n%=d;
            if( map.containsKey(n)){
                int idx =  map.get(n);
                res.insert(idx,"(");
                res.append(")");
                break;
            }else{
                map.put(n, res.length());
            }

        }
        return res.toString();
    }
    public static void main( String args[]){

    }
}
