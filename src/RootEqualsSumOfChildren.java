import LC.TreeNode;

public class RootEqualsSumOfChildren {
    public static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
