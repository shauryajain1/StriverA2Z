/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null) return result;
        queue.offer(root);
        boolean reverse=false;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<levelSize;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            if(reverse==true){
                Collections.reverse(subList);
                result.add(subList);
                reverse=false;
            }else{
                result.add(subList);
                reverse=true;
            }
        }
        return result;
    }
}