class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
                if (curCount > max) {
                    max = curCount;
                }
            } else {
                curCount = 0;
            }
        }
        return max;
    }
}