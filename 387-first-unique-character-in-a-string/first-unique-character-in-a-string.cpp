class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> umap;
        for (char c : s) umap[c]++; // \U0001f522 Count character frequency
        for (int i = 0; i < s.length(); i++) 
            if (umap[s[i]] == 1) return i; // \U0001f3af Find the first unique character
        return -1; // ❌ No unique character found
    }
};