package HeBingErChaShu;

public class HeBingErChaShu {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 在原有树上进行合并，无需创建新节点
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        // 返回合并后的第一棵树
        return root1;
    }

    public static void main(String[] args) {
        // 构造第一棵二叉树 [1, 3, 2, 5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        // 构造第二棵二叉树 [2, 1, 3, null, 4, null, 7]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        // 调用 mergeTrees 方法进行合并
        HeBingErChaShu solution = new HeBingErChaShu();
        TreeNode mergedTree = solution.mergeTrees(root1, root2);

        // 输出合并后的二叉树
        System.out.println("合并后的二叉树：");
        printTree(mergedTree);
    }

    // 辅助方法，用于打印二叉树（中序遍历）
    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

}
