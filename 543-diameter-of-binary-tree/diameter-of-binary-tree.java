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
    int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}