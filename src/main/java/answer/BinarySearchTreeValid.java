package answer;

import answer.domain.TreeNode;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午3:49
 */
public class BinarySearchTreeValid {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.right != null) {
            if (root.right.val <= root.val) return false;
            if (!isValidBSTNode(root.right,root.val,Long.MAX_VALUE)) return false;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) return false;
            if (!isValidBSTNode(root.left,Long.MIN_VALUE,root.val)) return false;
        }
        return true;
    }

    private boolean isValidBSTNode(TreeNode node, long min, long max) {
        if (node != null) {
            if (node.right != null) {
                if (node.right.val <= node.val || node.right.val >= max) return false;
                if (!isValidBSTNode(node.right, node.val, max)) return false;
            }

            if (node.left != null) {
                if (node.val <= node.left.val || node.left.val <= min) return false;
                if (!isValidBSTNode(node.left, min, node.val)) return false;
            }
        }
        return true;
    }
}
