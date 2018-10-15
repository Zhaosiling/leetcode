package answer;

import java.util.*;

/**
 * 描述:
 *  实际是图路径算法，需要注意广度优先的探索算法时间上不满足要求，应该用深度优先的探索模式。
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-11 下午5:06
 */
public class JumpArrayGame {
    public int jump(int[] nums) {
        int totalSteps = nums.length;
        if (totalSteps < 1) return totalSteps;

        LinkedList<Node> openList = new LinkedList<Node>();
        BitSet closeList = new BitSet(totalSteps+1);

        openList.add(new Node(0,0, nums[0]));
        while(!openList.isEmpty()) {
            Node node = openList.pop();
            if (node.pos == totalSteps-1) {
                return node.step;
            }

            int maxStep = nums[node.pos];
            if (node.pos+maxStep >= totalSteps-1) {
                return node.step+1;
            }

            for (int i = maxStep; i > 0; i--) {
                Integer nextPos = node.pos + i;
                // 第一次到达
                if (!closeList.get(nextPos)) {
                    Node nextNode = new Node(nextPos,node.step+1, nums[nextPos]);
                    insertToOpenList(openList, nextNode);
                }
            }

            // 标记已经探索过。
            closeList.set(node.pos);
        }

        return -1;
    }

    private void insertToOpenList(LinkedList<Node> openList, Node nextNode) {
        ListIterator<Node> it = openList.listIterator();
        while(it.hasNext()) {
            Node next = it.next();
            if (compareTo(nextNode,next) > 0) {
                it.previous();
                it.add(nextNode);
                return;
            }
        }
        it.add(nextNode);
    }

    private int compareTo(Node a, Node b) {
        int aWeigth = a.pos + a.maxPos;
        int bWeigth = b.pos + b.maxPos;
        if (aWeigth == bWeigth) {
            return a.pos - b.pos;
        }else{
            return aWeigth - bWeigth;
        }
    }

    class Node{
        public Integer pos;
        public Integer step;
        public Integer maxPos;

        Node(Integer pos, Integer step, Integer maxPos) {
            this.pos = pos;
            this.step = step;
            this.maxPos = maxPos;
        }
    }
}
