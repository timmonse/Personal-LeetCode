import java.util.HashSet;
import java.util.Set;

public class PathSumIII_437 {
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
    
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0);
        return count;
    }

    int count = 0;
    Set<TreeNode> set = new HashSet<>();

    public void dfs(TreeNode root, int target, int curr) {
        if (root == null) return;
        if (curr + root.val == target) {
            count++;
        }
        dfs(root.right, target, curr + root.val);
        dfs(root.left, target, curr + root.val);

        if (root.right != null && !set.contains(root.right)) {
            dfs(root.right, target, 0);
            set.add(root.right);
        }
        if (root.left != null && !set.contains(root.left)){
            dfs(root.left, target, 0);
            set.add(root.left);
        }
    }
}
