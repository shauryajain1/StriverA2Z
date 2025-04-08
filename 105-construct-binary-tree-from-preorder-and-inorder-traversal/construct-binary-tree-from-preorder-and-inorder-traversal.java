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
    private int indx=0;
    private HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);    //stores the values of inorder 
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int start,int end){
        if(start>end) return null;
        int rootval=preorder[indx++];
        TreeNode root=new TreeNode(rootval);

        int ind=map.get(rootval);

        root.left=build(preorder,start,ind-1);
        root.right=build(preorder,ind+1,end);
        return root;
        
    }
}