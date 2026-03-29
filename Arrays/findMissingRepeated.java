class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       long actualSum = 0, actualSquareSum = 0;
           int n = grid.length;
           long N = (long) n * n;


           // Compute the actual sum and sum of squares from the grid
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   int num = grid[i][j];
                   actualSum += num;
                   actualSquareSum += (long) num * num;
               }
           }


           // Compute the expected sum and sum of squares for numbers from 1 to N
           long expectedSum = (N * (N + 1)) / 2;
           long expectedSquareSum = (N * (N + 1) * (2 * N + 1)) / 6;


           // Calculate the differences: a - b and a² - b²
           long sumDifference = actualSum - expectedSum; // a - b
           long squareSumDifference = actualSquareSum - expectedSquareSum; // a² - b²


           // Use algebra to find a + b = (a² - b²) / (a - b)
           long sumAb = squareSumDifference / sumDifference;


           // From the two equations:
           // repeated (a) = (a + b + a - b) / 2
           // missing  (b) = (a + b - (a - b)) / 2
           int repeated = (int) ((sumAb + sumDifference) / 2);
           int missing = (int) ((sumAb - sumDifference) / 2);


           return new int[]{repeated, missing};
    }
}