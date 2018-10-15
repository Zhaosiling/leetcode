package test;

import answer.BinaryTreeLevelOrder;
import answer.domain.TreeNode;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午6:49
 */
public class BinaryTreeLevelOrderTest {

    @Test
    public void test() {
        List<Integer> cast = Lists.newArrayList(3,9,20,null,null,15,7);
        TreeNode root = TreeNode.of(cast);
        BinaryTreeLevelOrder func = new BinaryTreeLevelOrder();
        List<List<Integer>> out = func.levelOrder(root);
        System.out.println(out);
    }
}
