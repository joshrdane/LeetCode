import LC.TreeNode;

public class RecoverATreeFromPreorderTraversal {
    public static TreeNode recoverFromPreorder(String traversal) {
        return recoverFromPreorder(traversal, new int[1], 0);
    }

    static TreeNode recoverFromPreorder(String traversal, int[] position, int depth) {
        TreeNode node = null;
        int newDepth = 0;
        while (position[0] + newDepth < traversal.length() && traversal.charAt(position[0] + newDepth) == '-') {
            newDepth++;
        }
        if (newDepth == depth) {
            position[0] += newDepth;
            int i = position[0];
            do {
                i++;
            } while (i < traversal.length() && traversal.charAt(i) != '-');
            node = new TreeNode(Integer.parseInt(traversal.substring(position[0], i)));
            position[0] = i;
            node.left = recoverFromPreorder(traversal, position, newDepth + 1);
            if (node.left != null) {
                node.right = recoverFromPreorder(traversal, position, newDepth + 1);
            }
        }
        return node;
    }
}
