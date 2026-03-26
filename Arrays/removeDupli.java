class removeDupli{


    public static boolean removeDuplicate(int arr[]){
         HashMap<Integer>  map = new HashMap<>();

         for(int i = 0 ;i<arr.length ;i++){
            map.add(arr[i]);
         }
        

    }

    public static void main(String args[]){

        int arr[] = { 1, 2, 4, 7, 7, 5};
      
      System.out.println(" sorted ? "+ isSorted(arr));
    }

}

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack); // [10, 20, 30]
    }
}