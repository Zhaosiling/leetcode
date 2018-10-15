package answer;

import java.util.*;

/*
    两个玩家分别扮演猫（Cat）和老鼠（Mouse）在无向图上进行游戏，他们轮流行动。

    该图按下述规则给出：graph[a] 是所有结点 b 的列表，使得 ab 是图的一条边。

    老鼠从结点 1 开始并率先出发，猫从结点 2 开始且随后出发，在结点 0 处有一个洞。

    在每个玩家的回合中，他们必须沿着与他们所在位置相吻合的图的一条边移动。例如，如果老鼠位于结点 1，那么它只能移动到 graph[1] 中的（任何）结点去。

    此外，猫无法移动到洞（结点 0）里。

    然后，游戏在出现以下三种情形之一时结束：

    * 如果猫和老鼠占据相同的结点，猫获胜。
    * 如果老鼠躲入洞里，老鼠获胜。
    * 如果某一位置重复出现（即，玩家们的位置和移动顺序都与上一个回合相同），游戏平局。

    给定 graph，并假设两个玩家都以最佳状态参与游戏，如果老鼠获胜，则返回 1；如果猫获胜，则返回 2；如果平局，则返回 0。

    示例：

    输入：[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
    输出：0
    解释：
    4---3---1
    |   |
    2---5
     \ /
      0


    提示：

    3 <= graph.length <= 200
    保证 graph[1] 非空。
    保证 graph[2] 包含非零元素。
 */
public class Q913_CatAndMouse {
    public int catMouseGame(int[][] graph) {
        int mousePos = 1, catPos = 2;
        BitSet mouseGone = new BitSet();
        BitSet catGone = new BitSet();

        for(;;) {
            System.out.println("[mouse] " + mousePos);
            System.out.println("[cat] " + catPos);
            int mNext = mouseMove(graph[mousePos],mouseGone, graph[catPos], catGone);
            if (mNext == 0) return 1;
            if (mNext < 0) return 0;

            int cNext = catMove(graph[catPos], catGone, graph, mNext, mouseGone);
            if (mNext < 0) return 0;
            if (mNext == cNext) return 2;

            mousePos = mNext;
            catPos = cNext;
        }
        //return 1;
    }

    private Set<Integer> mouseCanMove(int[] links, BitSet gone) {
        Set<Integer> canMove = new HashSet<>();
        for (int i = 0; i < links.length; i++) {
            int next = links[i];
            if (!gone.get(next)) {
                canMove.add(next);
            }
        }
        return canMove;
    }

    private int mouseMove(int[] links, BitSet gone, int[] catLinks, BitSet catGone) {
        Set<Integer> mouseCanMove = mouseCanMove(links,gone);

        // 老鼠作弊算法
        if (mouseCanMove.size() > 0) {
            Set<Integer> catCanMove = catCanMove(catLinks,catGone);
            Optional<Integer> bestWay = mouseCanMove.stream()
                    .filter(n -> !catCanMove.contains(n)).findFirst();
            Integer best = bestWay.orElse(mouseCanMove.iterator().next());
            gone.set(best);
            return best;
        }else {
            return -1;
        }
    }

    private Set<Integer> catCanMove(int[] links, BitSet gone) {
        Set<Integer> canMove = new HashSet<>();
        for (int i = 0; i < links.length; i++) {
            int next = links[i];
            if (next == 0) continue;

            if (!gone.get(next)) {
                canMove.add(next);
            }
        }
        return canMove;
    }

    private int catMove(int[] links, BitSet gone, int[][] graph, int mousePos, BitSet mouseGone) {
        Set<Integer> catCanMove = catCanMove(links,gone);
        if (catCanMove.size() > 0) {
            Set<Integer> mouseNextCanMove = mouseCanMove(graph[mousePos],mouseGone);
            Optional<Integer> bestWay = catCanMove.stream()
                    .filter(n -> {
                        Set<Integer> catNextCanMove = catCanMove(graph[n],gone);
                        for (Integer mouseNext : mouseNextCanMove) {
                            if (catNextCanMove.contains(mouseNext)) return true;
                        }
                        return false;
                    }).findFirst();
            Integer best = bestWay.orElse(catCanMove.iterator().next());
            gone.set(best);
            return best;
        }else {
            return -1;
        }
    }
}
