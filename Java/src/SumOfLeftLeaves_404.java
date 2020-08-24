public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    public int sum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int val = 0;
        if (isLeft && root.left == null && root.right == null) val = root.val;
        return sum(root.left, true) + val + sum(root.right, false);
    }
}
