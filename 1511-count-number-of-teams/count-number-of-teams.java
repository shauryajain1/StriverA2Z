class Solution {
    public int numTeams(int[] rating) {
        int count=0;
        for(int j=0;j<rating.length;j++){
            int leftsmall=0,leftgreater=0;
            int rightsmall=0,rightgreater=0;
              for(int i=j-1;i>=0;i--){
                  if(rating[i]<rating[j]) leftsmall++;
                  else if(rating[i]>rating[j]) leftgreater++;
              }

              for(int k=j+1;k<rating.length;k++){
                    if(rating[k]<rating[j]) rightsmall++;
                  else if(rating[k]>rating[j]) rightgreater++;
              }

              count=count+(leftsmall*rightgreater)+(leftgreater*rightsmall);
        }
   return count;
    }
}