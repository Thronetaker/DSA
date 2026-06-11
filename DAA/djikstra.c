#include <stdio.h>
// single source shortest path

// Function to take matrix input
void adjmatrix(int n, int cost[20][20]) {
    int i, j;
    printf("\nEnter the cost adjacency matrix (%d x %d):\n", n, n);
    printf("(Use 0 for self-loops and 999 for no edge)\n");
    
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            scanf("%d", &cost[i][j]);
        }
    }
}

// Dijkstra Algorithm
void dijkstra(int u, int cost[20][20], int n) {
    int s[20], dist[20];
    int i, j, k, min, w;

    // 1. Initialization
    for (i = 1; i <= n; i++) {
        s[i] = 0;           // 0 means not visited
        dist[i] = cost[u][i]; // Initial distance from source u
    }

    s[u] = 1;    // Mark source as visited
    dist[u] = 0; // Distance to self is 0

    // 2. Main Loop
    for (j = 2; j <= n; j++) {
        min = 999;
        
        // Find the unvisited vertex 'k' with the minimum distance
        for (i = 1; i <= n; i++) {
            if (s[i] == 0 && dist[i] < min) {
                min = dist[i];
                k = i;
            }
        }

        s[k] = 1; // Mark vertex k as visited

        // 3. Relaxation: Update distances of neighbors of k
        for (w = 1; w <= n; w++) {
            if (s[w] == 0 && cost[k][w] != 999) {
                if (dist[w] > dist[k] + cost[k][w]) {
                    dist[w] = dist[k] + cost[k][w];
                }
            }
        }
    }

    // 4. Print the final shortest distances
    printf("\nShortest distances from source %d:\n", u);
    for (i = 1; i <= n; i++) {
        if (dist[i] == 999) 
            printf("To %d: INF\n", i);
        else 
            printf("To %d: %d\n", i, dist[i]);
    }
}

int main() {
    int n, cost[20][20], u;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    adjmatrix(n, cost);

    printf("\nEnter the source vertex: ");
    scanf("%d", &u);

    dijkstra(u, cost, n);

    return 0;
}