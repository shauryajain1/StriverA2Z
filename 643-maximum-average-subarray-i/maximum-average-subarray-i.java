class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; // Add new element, remove old element
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum * 1.0 / k; // Convert to double
    }
}