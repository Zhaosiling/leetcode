package test;

import answer.LongestPalindrome;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-10 下午4:07
 */
public class LongestPalindromeTest {
    final static List<Pair<String,String>> casts = new ArrayList<>();

    @Before
    public void initCases() {
        casts.add(new Pair<>("abcda","a"));
        casts.add(new Pair<>("babcd","bab"));
        casts.add(new Pair<>("1","1"));
        casts.add(new Pair<>("",""));
        casts.add(new Pair<>("ccccc","cccc"));
    }
    @Test
    public void test() {
        LongestPalindrome func = new LongestPalindrome();
        casts.stream().forEach(c -> Assert.assertTrue(c.getValue().equals(func.longestPalindrome(c.getKey()))));
    }
}
