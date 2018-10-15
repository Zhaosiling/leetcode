package test;

import answer.BinarySearchTreeValid;
import answer.domain.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午4:34
 */
public class BinarySearchTreeValidTest {
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(45);
        node1.right = node2;
        node2.left = node3;
        node3.right = node4;
        node4.right = node5;

        BinarySearchTreeValid binarySearchTreeValid = new BinarySearchTreeValid();
        Assert.assertFalse(binarySearchTreeValid.isValidBST(node1));
    }
}
