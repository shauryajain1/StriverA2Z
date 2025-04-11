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
    // Reversing postorder traversal
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //most optimal approach
       if(root == null){
        return ;
       }
       flatten(root.right);
       flatten(root.left);

       root.right = prev;
       root.left = null;
       prev = root; 
    }
}