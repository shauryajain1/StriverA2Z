class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++)
            pq.offer(nums[i]);
        int i=0;

        while(!pq.isEmpty()){
            int temp = pq.poll();
            nums[i] = pq.poll();
            nums[i+1] = temp;
            i += 2;
        }

        return nums;
        
    }
}
        