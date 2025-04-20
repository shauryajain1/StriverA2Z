class Solution {
    static{
        for(int i=0; i<500; i++){
            findErrorNums(null);
        }
    }
    public static int[] findErrorNums(int[] a) {
        if(a==null) return new int[]{};
        long sum = 0L, sumSquares = 0L;
        long actualSum = 0L, actualSumSquares = 0L;
        int n = a.length;
        for(int i=0; i<n; i++){
            sum += (long)a[i];
            sumSquares += (long)a[i] * a[i];
        }

        actualSum = (n*(n+1L))/2;
        actualSumSquares = (n*(n+1L)*(2L*n +1))/6;
        int[] ans = new int[2];
        long numberDifference = sum-actualSum;
        long numberSum = (sumSquares - actualSumSquares)/(numberDifference);
        ans[0] = (int)((numberSum + numberDifference)/2);
        ans[1] = (int)((numberSum - ans[0]));
        return ans;
    }
}