class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, 0, result);
        return result;
    }

    public void nQueens(char[][] board, int row, List<List<String>> result) {

        // base case
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';

                nQueens(board, row + 1, result);

                board[row][j] = '.'; // backtracking
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // convert board → List<String>
    public List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }

        return temp;
    }
}