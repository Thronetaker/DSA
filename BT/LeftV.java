import java.util.*;

public class LeftV {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right ;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair{
        int val;
        TreeNode n;
        Pair( int val , TreeNode t){
            this.val = val ;
            this.n = t;
        }
    }

    public static void leftView( TreeNode root){
        if( root == null) return ;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.val;
            TreeNode t = p.n;
            map.putIfAbsent(l, t.val);

            if(t.left != null){
                q.add( new Pair(l+1, t.left));
            }
            if(t.right != null){
                q.add( new Pair(l+1, t.right));
            }

        }
        display(map);
    }

    static void display( TreeMap<Integer,Integer> t){
        for( Map.Entry<Integer,Integer> entry : t.entrySet()){
            System.out.print( entry.getValue()+" ");
        }
    }
    

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right= new TreeNode(11);
        leftView(root);
        
    }
}
