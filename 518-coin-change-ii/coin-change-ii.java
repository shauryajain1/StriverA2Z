class Solution {

    int[] coins;
    Integer[][] memo;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.memo = new Integer[coins.length][amount + 1];

        return dp(0, amount);
    }

    private int dp(int i, int amount) {
        if (i >= coins.length || amount < 0) return 0;
        if (amount == 0) return 1;
        if (memo[i][amount] != null) return memo[i][amount];

        int ways = 0;
        ways += dp(i, amount - coins[i]);
        ways += dp(i + 1, amount);

        return memo[i][amount] = ways;
    }
}