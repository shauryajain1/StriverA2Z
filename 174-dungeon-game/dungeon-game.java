class Solution {
    public int solve(int i, int j, int m, int n, int[][] dun, int[][] dp) {
        // Out of bounds — invalid path, return max so it doesn't get chosen
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        // Base case: we've reached the princess
        if (i == m - 1 && j == n - 1) {
            // Minimum health needed is 1 after considering the cell's value
            return Math.max(1, 1 - dun[i][j]);
        }
        if (dp[i][j] != -1) return dp[i][j];

        // Explore the two possible paths — move right or move down
        int right = solve(i, j + 1, m, n, dun, dp);
        int down = solve(i + 1, j, m, n, dun, dp);

        // We want the path that needs the least health onward
        int total =Math.min(right, down)- dun[i][j];

        // Health must always be at least 1, never 0 or less
        return dp[i][j] = Math.max(1, total);
    }

    public int calculateMinimumHP(int[][] dun) {
        int m = dun.length, n = dun[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, m, n, dun, dp);
    }
}