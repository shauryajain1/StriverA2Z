class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while(n > 0){
            int s = n%10;
            sum += s;
            product *= s;
            n/= 10;
        }
        return product - sum;
    }
}