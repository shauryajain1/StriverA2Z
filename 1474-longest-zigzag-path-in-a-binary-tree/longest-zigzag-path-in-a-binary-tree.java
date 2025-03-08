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

    private enum direction {LEFT, RIGHT};
    private Map<TreeNode, Integer> map = new HashMap<>();
    private int maxDepth = 0;
    public int longestZigZag(TreeNode root) {
        // return longestZigZag(root, 0)-1;
        return Math.max(maxZigZag(root.left, direction.LEFT, 1), 
                            maxZigZag(root.right, direction.RIGHT, 1));
    }

    public int maxZigZag(TreeNode node, direction d, int depth) {
        if (node == null) {
            return 0;
        }

        int value1=0, value2=0;
        if(d == direction.LEFT) {
            int left = maxZigZag(node.left, direction.LEFT, 1);
            int right = maxZigZag(node.right, direction.RIGHT, depth +1 );
            maxDepth = Math.max(depth, maxDepth);
        }

        if(d == direction.RIGHT) {
            maxZigZag(node.right, direction.RIGHT, 1);
            maxZigZag(node.left, direction.LEFT, depth+1);
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }

    public int longestZigZag(TreeNode node, int maxLength) {
        if(node == null) {
            return maxLength -1;
        }

        maxLength = Math.max(longestZigZag(node.left, maxLength), longestZigZag(node.right, maxLength));

        int length = Math.max( go(node, direction.LEFT), go(node, direction.RIGHT));
        if(length > maxLength) {
            maxLength = length;
        }

        return maxLength;
    }

    public int go(TreeNode node, direction d) {
        if(node == null) {
            return 0;
        }
        if(d == direction.LEFT) {
            node = node.left;
            d = direction.RIGHT;
        } else {
            node = node.right;
            d = direction.LEFT;
        }

        return 1 + go(node, d);
    }
}