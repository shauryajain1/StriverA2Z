class Solution {
    Map<Integer, List<Integer>> map;
    Random random = new Random();

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list.size()==1) {
            return list.get(0);
        }
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */