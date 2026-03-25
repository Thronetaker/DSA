
class isSorted{

    public static boolean isSorted(int arr[]){

        for(int i = 1 ;i<arr.length ;i++){
            if(arr[i] < arr[i-1]){
                return false ;
            }
        }
        return true;

    }

    public static void main(String args[]){

        int arr[] = { 1, 2, 4, 7, 7, 5};
      
      System.out.println(" sorted ? "+ isSorted(arr));
    }
}