class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        // Boolean arrays to track conflicts
        boolean[] row = new boolean[n]; 
        boolean[] mainDiagonal = new boolean[2 * n];  // (row - col + n)
        boolean[] antiDiagonal = new boolean[2 * n]; // (row + col)
        backtrack(0, board, result, row, mainDiagonal, antiDiagonal, n);
        return result;
    }
    private void backtrack(int col, char[][] board, List<List<String>> result,
            boolean[] row, boolean[] mainDiagonal, boolean[] antiDiagonal, int n) {
        if (col == n) {
            // Convert board to List<String>
            List<String> solution = new ArrayList<>();
            for (char[] line : board) {
                solution.add(new String(line));
            }
            result.add(solution);
            return;
        }
        // Try placing a queen in each row
        for (int r = 0; r < n; r++) {
            if (row[r] || mainDiagonal[r - col + n] || antiDiagonal[r + col]) {
                continue; // Skip if position is attacked
            }
            // Place the queen
            board[r][col] = 'Q';
            row[r] = true;
            mainDiagonal[r - col + n] = true;
            antiDiagonal[r + col] = true;

            // Recur for next column
            backtrack(col + 1, board, result, row, mainDiagonal, antiDiagonal, n);

            // Backtrack and remove the queen
            board[r][col] = '.';
            row[r] = false;
            mainDiagonal[r - col + n] = false;
            antiDiagonal[r + col] = false;
        }
    }
}