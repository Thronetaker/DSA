#include <stdio.h>
#include <stdlib.h>

// Function to calculate the upper bound (Greedy estimate)
float Bound(int cp, int cw, int k, int n, int m, int p[], int w[]) {
    float b = (float)cp;
    float c = (float)cw;
    for (int i = k + 1; i <= n; i++) {
        c = c + w[i];
        if (c < m) {
            b = b + p[i];
        } else {
            // Fractional part if the item doesn't fit fully
            return b + (1.0 - (c - m) / (float)w[i]) * p[i];
        }
    }
    return b;
}

// Backtracking Knapsack Algorithm
void BKnap(int k, int cp, int cw, int n, int m, int p[], int w[], int x[], int y[], int *fp, int *fw) {
    
    // Generate left child (Include item k)
    if (cw + w[k] <= m) {
        y[k] = 1;
        if (k < n) {
            BKnap(k + 1, cp + p[k], cw + w[k], n, m, p, w, x, y, fp, fw);
        }
        if ((cp + p[k] > *fp) && (k == n)) {
            *fp = cp + p[k];
            *fw = cw + w[k];
            for (int j = 1; j <= k; j++) {
                x[j] = y[j];
            }
        }
    }

    // Generate right child (Exclude item k)
    // We check if the potential bound is better than our current best profit (fp)
    if (Bound(cp, cw, k, n, m, p, w) >= (float)(*fp)) {
        y[k] = 0;
        if (k < n) {
            BKnap(k + 1, cp, cw, n, m, p, w, x, y, fp, fw);
        }
        if ((cp > *fp) && (k == n)) {
            *fp = cp;
            *fw = cw;
            for (int j = 1; j <= k; j++) {
                x[j] = y[j];
            }
        }
    }
}

int main() {
    int n, m;

    // User Input for basic parameters
    printf("Enter the number of items (n): ");
    scanf("%d", &n);
    printf("Enter the knapsack capacity (m): ");
    scanf("%d", &m);

    // Local variables and arrays (1-based indexing, so size is n + 1)
    int p[11]; // Profits
    int w[11]; // Weights
    int x[11]; // Final best solution vector
    int y[11]; // Current path vector
    int fp = -1;  // Final max profit
    int fw = 0;   // Final weight

    // Initialize arrays
    for (int i = 0; i <= n; i++) {
        x[i] = 0;
        y[i] = 0;
    }

    // User Input for item details
    printf("\nNote: For the algorithm to work, enter items in non-increasing order of profit/weight ratio.\n");
    for (int i = 1; i <= n; i++) {
        printf("Enter profit and weight for item %d: ", i);
        scanf("%d %d", &p[i], &w[i]);
    }

    // Start the backtracking process
    BKnap(1, 0, 0, n, m, p, w, x, y, &fp, &fw);

    // Display Results
    printf("\n--- Results ---\n");
    if (fp == -1) {
        printf("No feasible solution found.\n");
    } else {
        printf("Max Profit (fp): %d\n", fp);
        printf("Final Weight (fw): %d\n", fw);
        printf("Selected items (x vector): ");
        for (int i = 1; i <= n; i++) {
            printf("%d ", x[i]);
        }
        printf("\n");
    }

    return 0;
}