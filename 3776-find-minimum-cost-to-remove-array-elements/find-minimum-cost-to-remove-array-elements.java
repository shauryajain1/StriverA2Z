class Solution {
    List<List<Long>> dp;

    long sol(int[] nums, long i, long p) {
        long n = nums.length;
        if (i >= n) {
            if (p < n && p >= 0)
                return nums[(int) p];
            return 0;
        }
        if (i == n - 1) {
            long maxi = nums[(int) i];
            if (p < n && p >= 0)
                maxi = Math.max(maxi, nums[(int) p]);
            return maxi;
        }
        if (dp.get((int) i).get((int) p) != -1)
            return dp.get((int) i).get((int) p);
        long ans = (long) 1e11;
        long j = i + 1;
        ans = Math.min(ans, Math.max(nums[(int) p], nums[(int) i]) + sol(nums, i + 2, i + 1));
        ans = Math.min(ans, Math.max(nums[(int) p], nums[(int) (i + 1)]) + sol(nums, i + 2, i));
        ans = Math.min(ans, Math.max(nums[(int) i], nums[(int) (i + 1)]) + sol(nums, i + 2, p));
        dp.get((int) i).set((int) p, ans);
        return ans;
    }

    public int minCost(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            if (n == 1)
                return nums[n - 1];
            return Math.max(nums[0], nums[1]);
        }
        dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Long> temp = new ArrayList<>(Collections.nCopies(n + 1, -1L));
            dp.add(temp);
        }
        long ans = (long) 1e11;
        ans = sol(nums, 1, 0);
        return (int) ans;
    }
}