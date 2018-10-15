package answer;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 描述:
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-10 下午4:06
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        byte[] chars = s.getBytes();
        if (chars.length < 1) {
            return s;
        }

        Map<Byte, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < chars.length; i ++){
            List<Integer> pos = new ArrayList<>();
            pos.add(i);
            maps.merge(chars[i], pos, new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
                @Override
                public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                    integers.addAll(integers2);
                    return integers;
                }
            });
        }

        List<Index> indexList = maps.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> {
                    List<Integer> posArray = e.getValue();
                    Integer minPos = posArray.get(0);
                    Integer maxPos = posArray.get(posArray.size()-1);
                    Integer maxLen = maxPos - minPos + 1;
                    if (maxLen == s.length() && posArray.size() > 2) {
                        maxPos = posArray.get(posArray.size()-2);
                        maxLen = maxPos - minPos + 1;
                    }
                    return new Index(maxLen, minPos, maxPos);
                })
                .sorted(Comparator.comparingInt(Index::getMaxLen))
                .filter(i -> i.maxLen < s.length()) // 必须是子串
                .collect(Collectors.toList());

        if (indexList != null && indexList.size() > 0) {
            Index index = indexList.get(indexList.size()-1);
            return s.substring(index.minPos,index.maxPos+1);
        }else{
            return s.substring(0,1);
        }
    }

    private class Index {
        public Integer maxLen;
        public Integer minPos;
        public Integer maxPos;

        public Integer getMaxLen() {
            return maxLen;
        }

        public Index(Integer len, Integer min, Integer max) {
            this.maxLen = len;
            this.minPos = min;
            this.maxPos = max;
        }
    }
}
