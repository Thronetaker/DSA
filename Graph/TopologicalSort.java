import java.util.*;

public class TopologicalSort{
    static class Edge {
        int src;
        int dest ;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void tSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                tSortUtil(graph, i, vis, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }


    }

    public static void tSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stack){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                tSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr);
    }

    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

        tSort(graph);


    }
}