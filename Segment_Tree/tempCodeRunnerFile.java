import java.util.*;


public class Segment{

    static int tree[] ;
    public static void init(int n ){
        tree = new int[4*n];
    }

    public  static int  BuildST(int arr[], int i, int start, int end){
        if (start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end )/2;
        int l = BuildST( arr, 2*i + 1 , start, mid);
        int r = BuildST(arr, 2*i+ 2, mid+1, end);

        tree[i] = tree[2*i + 1] + tree[2*i + 2];
        return tree[i];


    }

    public static int getSum(int i , int si, int sj , int qi, int qj){
        if( si >= qj || sj <=qi)
            return 0 ;
        else if( si >=qi || sj <= qj)
            return tree[i];
        else {
            int mid = (si + sj)/2;
            return getSum( 2*i +1 , si, mid,qi,qj) + getSum( 2*i + 1, mid+1, sj, qi, qj);
        }
    }
    
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8 };
        int n = arr.length;
        init(n);
        BuildST(arr, 0, 0, n-1);
        for(int i =0 ;i < tree.length ;i++){
            System.out.print(tree[i]+ " ");
        }
        System.out.print( getSum(0,0,n,4,7));


    }
}