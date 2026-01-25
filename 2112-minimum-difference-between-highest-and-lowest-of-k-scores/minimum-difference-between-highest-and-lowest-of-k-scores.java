class Solution {
    public int minimumDifference(int[] nums, int k) {   
        Arrays.sort(nums);
        int mi = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            mi = Math.min(mi, diff);
        }
        return mi;
    }
}