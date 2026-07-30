import java.util.*;


public class frogKJump {
    
    public static int kJump(List<Integer> heights, int k ){
        int n = heights.size();
        int dp[] = new int[n];   //here size also matters , as i have stored the  o idx value at o NOT 1   
        //computation matters 
        dp[0] =0;
        
        //bottom up approach
        for(int i = 1 ; i<n ;i++){
            int min = Integer.MAX_VALUE;
            
                for(int j = 1 ; j<= k;j++){
                    if(i -j >= 0){   // remember it 
                         int c = dp[i-j] + Math.abs(heights.get(i) -  heights.get(i-j));
                         min = Math.min(min,c);

                 }
              }
              dp[i] = min;

        }
        return dp[n-1];

    }

    public static void main(String main[]){
      List<Integer> h =  new ArrayList<>();
      h.add(10);
      h.add(5);
      h.add(20);
      h.add(0);
      h.add(15);
      System.out.println(kJump(h,2));
    }
}
