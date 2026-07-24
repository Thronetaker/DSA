import java.util.*;
public class SpiralM {
    public static void spiralMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0 , bottom =row-1, left = 0,right = col-1;

        List<Integer> res = new ArrayList<>();

        while( top <= bottom && left <= right){

            for(int i = left ; i<= right ; i++){
                res.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i<= bottom ; i++){
                res.add(matrix[right][i]);
            }
            right--;

            if( top <= bottom){
                for(int i = right ; i>= left ; i--){
                res.add(matrix[bottom][i]);
              }
               bottom--;
            }


            if( left <= right){
                for(int i = bottom ; i>= top ; i--){
                    res.add(matrix[left][i]);
                 } 
                left++;
            }
        }

    }
}
