import resources.TreeNode;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root.right == null && root.left == null) return 1;
        if (root.right == null) return recur(root.left) + 1;
        if (root.left == null) return recur(root.right) + 1;
        return Math.min(recur(root.left) + 1, recur(root.right) + 1);
    }
}
