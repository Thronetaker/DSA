#include <stdio.h>

// Algorithm BFS(v)
void BFS(int v, int n, int G[20][20], int visited[], int q[], int *front, int *rear) {
    int u = v;
    visited[v] = 1;
    printf("%d ", v);

    do {
        // For all vertices w adjacent from u
        for (int w = 1; w <= n; w++) {
            if (G[u][w] != 0 && visited[w] == 0) {
                // Add w to q
                (*rear)++;
                q[*rear] = w;
                
                visited[w] = 1;
                printf("%d ", w);
            }
        }

        // If q is empty then return
        if (*front == *rear) return;

        // Delete u from q (Get first unexplored vertex)
        (*front)++;
        u = q[*front];

    } while (1); // until(false)
}

// Algorithm BFT(G, n)
void BFT(int n, int G[20][20], int visited[]) {
    // Local queue variables
    int q[100];
    int front = 0;
    int rear = 0;

    // for i := 1 to n do Mark all vertices unvisited
    for (int i = 1; i <= n; i++) {
        visited[i] = 0;
    }

    // for i := 1 to n do if (visited[i] = 0) then BFS(i)
    for (int i = 1; i <= n; i++) {
        if (visited[i] == 0) {
            BFS(i, n, G, visited, q, &front, &rear);
        }
    }
}

int main() {
    int n;
    int G[20][20] = {0};
    int visited[20] = {0};

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter Adjacency Matrix (%d x %d):\n", n, n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            scanf("%d", &G[i][j]);
        }
    }

    printf("\nBreadth First Traversal sequence: ");
    BFT(n, G, visited);
    printf("\n");

    return 0;
}