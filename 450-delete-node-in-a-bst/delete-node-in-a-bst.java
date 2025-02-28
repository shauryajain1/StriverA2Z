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

    public TreeNode delete(TreeNode root){
        if(root.left == null || root.right == null) 
            return root.left == null?root.right:root.left;
        
        TreeNode right = root.right;
        while(right.left != null)
            right = right.left;
        
        right.left = root.left;
        return root.right;
    }

    public boolean helper(TreeNode root, int key){
        if(root == null)
            return false;
        if(root.left != null && root.left.val == key){
            root.left = delete(root.left);
            return true;
        }
        else if(root.right != null && root.right.val == key){
            root.right = delete(root.right);
            return true;
        }
        if(root.val > key)
            return helper(root.left, key);
        return helper(root.right, key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val == key)return delete(root);
    
        helper(root, key);
        return root;
    }
}