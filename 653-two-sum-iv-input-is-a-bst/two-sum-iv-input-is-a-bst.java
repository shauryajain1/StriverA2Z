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
    HashSet<Integer>hs = new HashSet<>();
    int tar;
    public boolean findTarget(TreeNode root, int k) {
       
        this.tar = k;
        return  findTarget(root);
    }
    public boolean findTarget(TreeNode root)
    {
        if(root == null)
        {
            return false;
        }

        boolean l = findTarget(root.left);
        boolean r = findTarget(root.right);
        if(hs.contains(tar-root.val))
        {
            return true;
        }
        hs.add(root.val);
        return l ||  r;
    }
}