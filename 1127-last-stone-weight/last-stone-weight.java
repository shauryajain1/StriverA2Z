class Solution {
    public int lastStoneWeight(int[] s) {
        Arrays.sort(s);  
        for(int i=s.length-1;i>=1;i--){
            int dif=s[i]-s[i-1];
            s[i-1]=dif; 
            Arrays.sort(s,0,i);   
        }
        return s[0];    
    }
}