package answer.domain;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-12 下午6:30
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    static public TreeNode of(List<Integer> data) {
        if (data.size() == 0) return null;
        return generatorTreeNode(data,0);
    }

    static public TreeNode generatorTreeNode(List<Integer> data, int pos) {
        if(pos >= data.size()) return null;
        Integer val = data.get(pos);
        if (val == null) return null;

        TreeNode root = new TreeNode(data.get(pos));
        root.left = generatorTreeNode(data,pos * 2 + 1);
        root.right = generatorTreeNode(data,pos * 2 + 2);

        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
