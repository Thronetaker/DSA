public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {

    if (src == dest) {
        return true;
    }

    vis[src] = true;

    for (int i = 0; i < graph[src].size(); i++) {
        Edge e = graph[src].get(i);
        // e.dest = neighbour

        if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
            return true;
        }
    }

    return false;
}