class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] ans  = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;++i){
            while(!stack.isEmpty() && nums[i]>stack.peek()[1]){
                int[] curr= stack.pop();
                ans[curr[0]]= i-curr[0];
            }
            stack.push(new int[]{i,nums[i]});
        }
        return ans;
    }
}