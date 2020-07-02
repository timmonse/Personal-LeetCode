import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreeLevelOrderTraversalI_107 {
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

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        depthFirstSearch(root, 0);
        return resultList;
    }

    public void depthFirstSearch(TreeNode root, int depth) {
        List<Integer> levelList;
        if (root == null) {
            return;
        }

        depthFirstSearch(root.left, depth + 1);

        int lengthAdjust = depth - (resultList.size() - 1);
        for (int i = 0; i < lengthAdjust; i++) {
            resultList.add(0, new ArrayList<Integer>());
        }
        int resultListSize = resultList.size();
        levelList = resultList.get(resultListSize - 1 - depth);
        levelList.add(root.val);
        resultList.set(resultListSize - 1 - depth, levelList);

        depthFirstSearch(root.right, depth + 1);
    }
}