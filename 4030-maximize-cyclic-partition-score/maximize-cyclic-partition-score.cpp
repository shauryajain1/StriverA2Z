#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#include <set>

using namespace std;

class Solution {
public:
    long long maximumScore(vector<int>& nums, int k) {
        int n = nums.size();
        if (n == 0) return 0;
        
        // Find global min and max to determine candidate start positions
        int min_val = INT_MAX;
        int max_val = INT_MIN;
        for (int x : nums) {
            if (x < min_val) min_val = x;
            if (x > max_val) max_val = x;
        }

        // Identify candidate start indices (cuts often happen near extrema)
        vector<int> candidates;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == min_val || nums[i] == max_val) {
                candidates.push_back(i); // Cut before i (i becomes start)
                candidates.push_back((i + 1) % n); // Cut after i
            }
        }
        
        // Remove duplicates and limit candidates to prevent TLE on flat arrays
        sort(candidates.begin(), candidates.end());
        candidates.erase(unique(candidates.begin(), candidates.end()), candidates.end());
        
        // If there are too many candidates (e.g. flat array), pick a few
        if (candidates.size() > 5) {
            candidates.resize(5);
        }

        long long global_max_score = 0;

        // Determine lookback limit based on K
        // Heuristic: Optimal segments are rarely much larger than N/K
        int lookback_limit = (n / k) * 2 + 20; 
        if (lookback_limit > n) lookback_limit = n;

        // DP State Buffers
        vector<long long> dp(n + 1, -1);
        vector<long long> next_dp(n + 1, -1);
        vector<int> current_nums(n);

        for (int start_idx : candidates) {
            // Rotate array
            for (int i = 0; i < n; ++i) {
                current_nums[i] = nums[(start_idx + i) % n];
            }

            // --- Linear DP ---
            
            // Initialization: 1 Partition (Base Case)
            // dp[i] = score of subarray current_nums[0...i-1]
            int c_min = current_nums[0];
            int c_max = current_nums[0];
            dp[0] = 0; // dummy
            
            // Fill 1st partition manually
            for (int i = 1; i <= n; ++i) {
                int val = current_nums[i-1];
                if (val < c_min) c_min = val;
                if (val > c_max) c_max = val;
                dp[i] = (long long)c_max - c_min;
            }
            
            // Update global max for k >= 1
            if (dp[n] > global_max_score) global_max_score = dp[n];

            // Iterate partitions p from 2 to k
            for (int p = 2; p <= k; ++p) {
                fill(next_dp.begin(), next_dp.end(), -1);
                
                // For each end position 'i'
                // We start 'i' from 'p' because we need at least p elements for p partitions
                for (int i = p; i <= n; ++i) {
                    int seg_min = current_nums[i-1];
                    int seg_max = current_nums[i-1];
                    long long best_for_i = -1;
                    
                    // Optimization: Only look back 'lookback_limit' steps
                    // j is the end of the previous partition
                    int start_j = max(p - 1, i - lookback_limit);
                    
                    for (int j = i - 1; j >= start_j; --j) {
                        int val = current_nums[j];
                        if (val < seg_min) seg_min = val;
                        if (val > seg_max) seg_max = val;
                        
                        // If previous state is valid
                        if (dp[j] != -1) {
                            long long total = dp[j] + (long long)(seg_max - seg_min);
                            if (total > best_for_i) best_for_i = total;
                        }
                    }
                    next_dp[i] = best_for_i;
                }
                
                dp = next_dp;
                // Update global max with result of using 'p' partitions
                // Problem asks for "at most k", so we check every p
                if (dp[n] > global_max_score) global_max_score = dp[n];
            }
        }
        
        return global_max_score;
    }
};