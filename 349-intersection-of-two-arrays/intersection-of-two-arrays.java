class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set  =new HashSet<>();
        int res []= new int [nums1.length+1];
        for(int k : nums1){
             set.add(k);
        }
        int z = 0 ;
        int count= 0 ;
        for(Integer k :nums2){
            if(set.contains(k)){
                res[z++] =k;
                set.remove(k);
                count++;
            }
        }
        int temp[] = new int[count];
        for(int i = 0 ; i <count;i++)
{
    temp[i]=res[i];
}        return temp;

    }
}