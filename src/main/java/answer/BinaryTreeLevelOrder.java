package answer;

import answer.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午6:30
 */
public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orders = new ArrayList<List<Integer>>();
        getOrderByLevel(root,orders,0);
        return orders;
    }

    private void getOrderByLevel(TreeNode root, List<List<Integer>> orders, Integer depth) {
        if (root == null) return;
        int size = orders.size();

        if (depth == size) {
            orders.add(depth,new ArrayList<Integer>());
        }

        List<Integer> level = orders.get(depth);
        level.add(root.val);

        getOrderByLevel(root.left, orders, depth+1);
        getOrderByLevel(root.right, orders, depth+1);
    }
}
