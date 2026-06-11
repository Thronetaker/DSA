#include <stdio.h>

// k = current vertex index
// x[] stores colors assigned to vertices
// m = number of available colors
// n = number of vertices
// G[][] = Adjacency matrix

void nextValue(int x[], int k, int m, int n, int G[20][20]) {
    int i;
    do {
        // Increment the color for vertex k
        x[k] = (x[k] + 1) % (m + 1); 

        // If color cycle wraps back to 0, no color is available
        if (x[k] == 0) return;

        // Check if this color is used by any adjacent vertex
        for (i = 1; i <= n; i++) {
            if (G[k][i] != 0 && x[i] == x[k]) {
                // Conflict found, break to try next color
                break;
            }
        }
        
        // If i reaches n+1, no conflict was found
        if (i == n + 1) return;
    } while (1);
}

void mColoring(int x[], int k, int m, int n, int G[20][20]) {
    do {
        // Assign a valid color to vertex k
        nextValue(x, k, m, n, G);

        // If no color can be assigned, backtrack
        if (x[k] == 0) return;

        // If all vertices are colored, print the solution
        if (k == n) {
            printf("Coloring sequence: ");
            for (int i = 1; i <= n; i++) {
                printf("%d ", x[i]);
            }
            printf("\n");
        } else {
            // Color the next vertex
            mColoring(x, k + 1, m, n, G);
        }
    } while (1);
}

int main() {
    int n, m;
    int x[20] = {0};      // Solution vector (initialized to 0)
    int G[20][20] = {0};  // Adjacency matrix

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of colors: ");
    scanf("%d", &m);

    printf("Enter adjacency matrix (1 if connected, 0 otherwise):\n");
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            scanf("%d", &G[i][j]);
        }
    }

    printf("\nPossible solutions:\n");
    // Start coloring from the first vertex
    mColoring(x, 1, m, n, G);

    return 0;
}