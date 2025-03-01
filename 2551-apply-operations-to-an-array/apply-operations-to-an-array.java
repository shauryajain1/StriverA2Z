class Solution {
    public int[] applyOperations(int[] nums) {
        int k,i;
        for(i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        for( i=0,k=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            continue;
            else
            {
                nums[k++]=nums[i];

            }

        }
        for( i=k;i<nums.length;i++)
        {
            nums[i]=0;
        }
        return nums;
    }
}