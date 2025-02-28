class Solution {
    public int equalPairs(int[][] grid) { 
        int n = grid.length;
        int count = 0; 
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for(int[] row : grid){
            List<Integer> list = new ArrayList<>();
            for(int num : row){
                list.add(num);
            }
            map.put(list, map.getOrDefault(list,0)+1);
        }
        for(int col =0; col < n; col++){
            List<Integer> list2 = new ArrayList<>();
            for(int k=0; k<n; k++){
                list2.add(grid[k][col]);
            }
            count += map.getOrDefault(list2,0);
        }
        return count;
    }
}