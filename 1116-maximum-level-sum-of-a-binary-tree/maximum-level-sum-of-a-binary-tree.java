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
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public void levelOrder(TreeNode root,int currLvl,int level,int[] arr){
        if(root==null) return;
        arr[currLvl] += root.val;
        levelOrder(root.left,currLvl+1,level,arr);
        levelOrder(root.right,currLvl+1,level,arr);
    }
    public int maxLevelSum(TreeNode root) {
        int lvl = level(root);
        int[] arr = new int[lvl];
        levelOrder(root,0,lvl,arr);
        int mx = Integer.MIN_VALUE;
        int mxidx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mx){
                mx = arr[i];
                mxidx=i;
            }
        }
        return mxidx + 1;
    }
}