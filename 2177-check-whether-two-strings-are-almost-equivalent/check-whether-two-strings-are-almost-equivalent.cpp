class Solution {
public:
    bool checkAlmostEquivalent(string word1, string word2) {
        vector<int> mp(26,0),pa(26,0);
        int n=word1.size();
        for(int i=0;i<n;i++)
        {
            mp[word1[i]-'a']++;
            pa[word2[i]-'a']++;
        }
        for(int i=0;i<26;i++)
            if(abs(mp[i]-pa[i])>3)
                return false;
        return true;
    }
};