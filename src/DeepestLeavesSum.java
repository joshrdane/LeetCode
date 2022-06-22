import LC.TreeNode;

public class DeepestLeavesSum {
    public static int deepestLeavesSum(TreeNode root) {
        return leavesSumAtDepth(root, getDepth(root, 0));
    }

    private static int leavesSumAtDepth(TreeNode root, int depth) {
        if (--depth == 0 && root != null) {
            return root.val;
        }
        return root == null ? 0 : leavesSumAtDepth(root.left, depth) + leavesSumAtDepth(root.right, depth);
    }

    private static int getDepth(TreeNode root, int depth) {
        return root == null ? depth : Math.max(getDepth(root.left, depth + 1), getDepth(root.right, depth + 1));
    }
}
