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
    public boolean findTarget(TreeNode root, int k) {
        return checkSum(root, root, k);
    }

    public boolean checkSum(TreeNode node, TreeNode root, int target){
        if(node == null) return false;
        int diff = target - node.val;

        if(diff < node.val){
            if (search(root.left, diff, node)) return true;
        }
        if(diff > node.val){
            if (search(root.right, diff, node)) return true;
        }

        return checkSum(node.left, root, target) || checkSum(node.right, root, target);

    }

    public boolean search(TreeNode node, int target, TreeNode ignoreNode){
        while(node != null){
            if(node.val == target && node != ignoreNode)return true;
            node = target < node.val ? node.left : node.right;
        }
        return false;
    }

}