import java.util.*;

public class RobotRet {

    public static boolean RobotReturn(String s){
        int mx = 0, my =0 ;
        for(char ch : s.toCharArray()){
            if(ch == 'U') my++;
            else if( ch == 'D') my--;
            else if (ch == 'R') mx++;
            else if(ch == 'L') mx--;
        }

        if(mx == 0 && my == 0)return true;
        else return false;
    }
    

    public static void main( String args[]){
      String s = "UDDUR";
      System.out.println(RobotReturn(s));
    }
}
