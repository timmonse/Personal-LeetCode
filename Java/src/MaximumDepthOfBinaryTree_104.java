/**
 * Definition for a binary tree node.
 * public class resources.TreeNode {
 * int val;
 * resources.TreeNode left;
 * resources.TreeNode right;
 * resources.TreeNode() {}
 * resources.TreeNode(int val) { this.val = val; }
 * resources.TreeNode(int val, resources.TreeNode left, resources.TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class MaximumDepthOfBinaryTree_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + maxDepth(root.right);
        } else if (root.right == null) {
            return 1 + maxDepth(root.left);
        } else {
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }
}
