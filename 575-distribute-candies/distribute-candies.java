class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(candyType[i]);
        }
        if(set.size()>n/2)
        {
            return n/2;
        }
        else
        {
            return set.size();
        }
    }
}