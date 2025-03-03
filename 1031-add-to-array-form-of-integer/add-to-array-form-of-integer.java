class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result=new ArrayList<>();
        int n=num.length;

        for(int i=n-1;i>=0;i--){
            k+=num[i];
            result.add(k%10); 
            k/=10; 
        }
        while(k>0){
            result.add(k%10);
            k/=10;
        }
        Collections.reverse(result);
        return result;
    }
}