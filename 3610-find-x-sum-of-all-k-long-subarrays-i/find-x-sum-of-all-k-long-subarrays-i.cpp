class Solution {
public:
    vector<int> findXSum(vector<int>& nums, int k, int x) {
        const int MAXV = 51;
        int n = nums.size();
        vector<int> ans, freq(MAXV, 0);
        
        for (int i = 0; i < k; i++) freq[nums[i]]++;
        
        for (int i = 0; i + k <= n; i++) {
            vector<pair<int, int>> vals;
            for (int v = 1; v < MAXV; v++) {
                if (freq[v]) vals.push_back({v, freq[v]});
            }

            sort(vals.begin(), vals.end(), [](auto &a, auto &b) {
                if (a.second != b.second) return a.second > b.second;
                return a.first > b.first;
            });
        
            int sum = 0;
            for (int j = 0; j < x && j < (int)vals.size(); j++) {
                sum += vals[j].first * vals[j].second;
            }
            ans.push_back(sum);
            
            if (i + k < n) {
                freq[nums[i]]--;
                freq[nums[i + k]]++;
            }
        }
        return ans;
    }
};