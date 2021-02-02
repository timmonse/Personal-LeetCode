import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class resources.TreeNode {
 *     int val;
 *     resources.TreeNode left;
 *     resources.TreeNode right;
 *     resources.TreeNode() {}
 *     resources.TreeNode(int val) { this.val = val; }
 *     resources.TreeNode(int val, resources.TreeNode left, resources.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeLevelOrderTraversal_102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> main = new ArrayList<List<Integer>>();
        if (root == null) return main;
        return preOrder(main, root, 1);
    }

    public List<List<Integer>> preOrder(List<List<Integer>> main, TreeNode root, int level) {
        List<Integer> currentLevel;
        if (main.size() < level) {
            currentLevel = new ArrayList<Integer>();
            currentLevel.add(root.val);
            main.add(currentLevel);
        } else {
            currentLevel = main.get(level - 1);
            currentLevel.add(root.val);
            main.set(level - 1, currentLevel);
        }


        if (root.left != null) {
            preOrder(main, root.left, level + 1);
        }
        if (root.right != null) {
            preOrder(main, root.right, level + 1);
        }

        return main;
    }
}
