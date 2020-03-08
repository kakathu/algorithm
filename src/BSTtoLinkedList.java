import java.util.HashMap;

public class  BSTtoLinkedList {
    private TreeNode pre, head;
    private void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        visit(root);
        dfs(root.right);
    }

    private void visit(TreeNode curr) {
        curr.left = pre;
        if(pre == null) {
            head = curr;
        } else
            pre.right = curr;
        pre = curr;
    }

    public TreeNode transform(TreeNode root) {
        dfs(root);
        return head;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}
