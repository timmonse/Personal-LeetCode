public class SumOfRootToLeafBinaryNumbers_1022 {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        addBinary(root, 0);
        return sum;
    }

    public void addBinary(TreeNode root, int pathSum) {
        if (root == null) return;

        pathSum *= 2;
        pathSum += root.val;
        if (root.left == null && root.right == null) {
            sum += pathSum;
            return;
        }
        addBinary(root.left, pathSum);
        addBinary(root.right, pathSum);
    }
}
