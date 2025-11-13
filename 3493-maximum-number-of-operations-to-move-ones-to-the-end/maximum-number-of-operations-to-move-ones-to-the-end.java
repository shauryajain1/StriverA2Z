class Solution {
    public int maxOperations(String s) {
        long ans = 0, cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cnt++;
            else if (i > 0 && s.charAt(i - 1) == '1') ans += cnt;
        }
        return (int) ans;
    }
}