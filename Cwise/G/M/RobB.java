import java.util.*;

public class RobB {

    public static boolean robotBound(String s){
        int x = 0, y = 0;
        char d = 'N';
         for(char ch : s.toCharArray()){
            

            if( ch == 'G'){
                if(d == 'N')y++;
                else if( d== 'E') x++;
                else if( d=='S') y--;
                else if (d == 'W') x--;
            }else if ( ch == 'L'){
                if(d == 'N')  d = 'W';
                else if(d == 'W') d ='S';
                else if(d == 'S')  d = 'E';
                else if( d == 'E') d = 'N';
            }else if ( ch == 'R'){
                if(d == 'N')  d = 'E';
                else if(d == 'E') d ='S';
                else if(d == 'S')  d = 'W';
                else if( d == 'W') d = 'N';
            }
         }

         if( x == 0 && y==0  || d!='N') return true;
         else return false ;

    }

    public static void main(String args[]){
       String s = "GGLLGG";
       System.out.println(robotBound(s));
    }
}

