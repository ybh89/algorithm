package new2026.leetcode.bfs;

public class _112 {
    boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum, 0);
        return result;
    }

    public void dfs(TreeNode current, int targetSum, int currentSum) {
        currentSum += current.val;

        // 백트랙킹
        if (currentSum > targetSum) {
            return;
        }

        if (isLeaf(current)) {
            if (currentSum == targetSum) {
                result = true;
                return;
            }
        }

        if (current.left != null) {
            dfs(current.left, targetSum, currentSum);
        }

        if (current.right != null) {
            dfs(current.right, targetSum, currentSum);
        }
    }

    public boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
