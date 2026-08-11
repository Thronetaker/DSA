import java.util.*;


public class BotV{
    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left =null;
            this.right = null;
        }
    }
    static class Pair{
        int val;
        TreeNode n;
        Pair(int val , TreeNode t){
            this.val = val;
            this.n = t;
        }
    }
    public static void display(TreeMap<Integer,Integer> map ){
        for( Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print( entry.getValue() + " ");

        }
    }
    public static void botV(TreeNode root){
          if( root ==null) return ;

          Queue<Pair> q = new LinkedList<>();
          q.add(new Pair (0, root));
          TreeMap<Integer,Integer> map = new TreeMap<>(); //put

          while(!q.isEmpty()){
            Pair p = q.poll();
            int vertice = p.val;
            TreeNode t = p.n;

            map.put(vertice,t.val );


            if( t.left != null){
                q.add(new Pair(vertice -1, t.left));

            }

            if( t.right != null){
                q.add(new Pair(vertice +1, t.right));
            }

          }

          display(map);

    }

    public static void main( String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right= new TreeNode(11);
        botV(root);
        
    }
}