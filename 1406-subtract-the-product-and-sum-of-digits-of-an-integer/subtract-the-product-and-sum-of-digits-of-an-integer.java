class Solution {
    public int subtractProductAndSum(int n) {
        int diff=0;
        int pro=1,sum=0;
        while(n!=0)
        {
            int d=n%10;
            pro*=d;
            sum+=d;
            n=n/10;
        }
        diff=pro-sum;
        return diff;
    }
}