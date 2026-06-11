#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Algorithm Place(k, i)
// Returns true if a queen can be placed in kth row and ith column.
bool Place(int k, int i, int x[]) {
    for (int j = 1; j <= k - 1; j++) {
        // Check if two are in the same column 
        // or in the same diagonal
        if ((x[j] == i) || (abs(x[j] - i) == abs(j - k))) {
            return false;
        }
    }
    return true;
}

// Algorithm NQueens(k, n)
// Prints all possible placements of n queens on an n x n chessboard
void NQueens(int k, int n, int x[]) {
    for (int i = 1; i <= n; i++) {
        if (Place(k, i, x)) {
            x[k] = i;
            if (k == n) {
                // Write (x[1 : n])
                for (int j = 1; j <= n; j++) {
                    printf("%d ", x[j]);
                }
                printf("\n");
            } else {
                NQueens(k + 1, n, x);
            }
        }
    }
}

int main() {
    int n;

    printf("Enter the number of queens (n): ");
    scanf("%d", &n);

    // Local variable array using 1-based indexing (size n+1)
    int x[20]; 
    
    // Initialize array
    for(int i = 0; i <= n; i++) x[i] = 0;

    printf("Possible solutions (column positions for each row):\n");
    if (n <= 0) {
        printf("Invalid input.\n");
    } else {
        // Start algorithm from the first queen (k = 1)
        NQueens(1, n, x);
    }

    return 0;
}