class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=n-1;
        int c=0;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==k) {
                c++;
                left++;
                right--;
            }
            else if(sum>k){
                right--;
            }
            else{
                left++;
            }
        }
        return c;
    }
}