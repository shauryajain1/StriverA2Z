class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        if(str.length() < k) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            int div = Integer.parseInt(str.substring(i, i + k));
            if (div == 0) {
                continue;
            }
            if (num % div == 0) {
                ans++;
            }
        }
        return ans;
    }
}