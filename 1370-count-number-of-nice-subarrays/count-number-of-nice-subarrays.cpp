class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        int oddCount = 0;   
        int count = 0;     
        int prevCount = 0;  
        int i = 0, j = 0;   

        while (j < n) {
            
            if (nums[j] % 2 != 0) { 
                oddCount++;
                prevCount = 0; 
            }

            while (oddCount == k) {
                prevCount++; 
                if (nums[i] % 2 != 0) oddCount--; 
                i++; 
            }

            count += prevCount; 
            j++;
        }

        return count;
    }
};