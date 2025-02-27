class Solution {
    static int rec(int i, int prices[], int buyStatus, int dp[][], int fee){
        //base case
        if(i == prices.length){
            return 0;
        }
        //If avail in Dp array
        if(dp[i][buyStatus] != -1){
            return dp[i][buyStatus];
        }
        int ans = 0;

        // no stocks
        if(buyStatus == 0){
            //not buy
            int notBuy = rec(i+1, prices, 0, dp, fee);
            //buy
            int buy  = -prices[i] + rec(i+1, prices, 1, dp, fee);

            ans = Math.max(notBuy, buy);
        }
        // stocks avail
        else{
            //not sell
            int notSell = rec(i+1, prices, 1, dp, fee);
            //sell
            int sell = prices[i]+ rec(i+1, prices, 0 , dp, fee)-fee;

            ans = Math.max(notSell , sell);
        }
        dp[i][buyStatus] = ans;
        return ans;
    }

    public int maxProfit(int[] prices, int fee) {
        int i = 0;
        int buyStatus =0;
        int dp[][] = new int[prices.length][2];

        for(int k=0; k<prices.length; k++){
            for(int j=0; j<2; j++){
                dp[k][j] = -1;
            }
        }
        return rec(i, prices, buyStatus, dp, fee);
    }
}