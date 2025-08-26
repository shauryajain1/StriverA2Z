class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        int maxdiag=0, maxarea=0;
        for(int i=0; i<n;i++)
        {
            int l= dimensions[i][0];
            int w=dimensions[i][1];
            int diag=l*l +w*w;
            if(diag> maxdiag || (diag==maxdiag&& l*w>maxarea))
            {
                maxdiag=diag;
                maxarea=l*w;
            }

        }
        return maxarea;
        
    }
}