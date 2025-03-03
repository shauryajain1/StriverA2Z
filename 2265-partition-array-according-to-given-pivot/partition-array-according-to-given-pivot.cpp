class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> v1;
        vector<int> v2;
        vector<int> v3;
        vector<int> concatenated;
        int count = 0;
        for(int i=0;i<nums.size();i++){
            if(nums[i] < pivot){
                v1.push_back(nums[i]);
            }else if(nums[i] == pivot){
                v2.push_back(nums[i]);
            }else{
                v3.push_back(nums[i]);
            }
        }

     concatenated.reserve(v1.size() + v2.size() + v3.size());

    // Copy elements using std::copy
    std::copy(v1.begin(), v1.end(), std::back_inserter(concatenated));
    std::copy(v2.begin(), v2.end(), std::back_inserter(concatenated));
    std::copy(v3.begin(), v3.end(), std::back_inserter(concatenated));
       
        return concatenated;
    }
};