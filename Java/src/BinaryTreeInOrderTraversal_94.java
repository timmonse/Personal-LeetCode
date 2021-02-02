import java.util.ArrayList;
import java.util.List;

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
class BinaryTreeInOrderTraversal_94 {
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


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        if (root.right == null && root.left == null) {
            resultList.add(root.val);
            return resultList;
        }

        if (root.left != null) {
            leftList = inorderTraversal(root.left);
        }
        if (root.right != null) {
            rightList = inorderTraversal(root.right);
        }

        if (leftList != null) {
            resultList.addAll(leftList);
        }
        resultList.add(root.val);
        if (rightList != null) {
            resultList.addAll(rightList);
        }

        return resultList;
    }
}
