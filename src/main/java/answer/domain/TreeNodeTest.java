package answer.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午7:06
 */
public class TreeNodeTest {
    @Test
    public void test() {
        List<Integer> cast = new ArrayList<Integer>();
        cast.add(3);
        cast.add(9);
        cast.add(20);
        cast.add(null);
        cast.add(null);
        cast.add(15);
        cast.add(7);

        TreeNode root = TreeNode.of(cast);
        System.out.println(root.toString());
    }
}
