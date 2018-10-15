package test;

import answer.Q913_CatAndMouse;
import org.junit.Assert;
import org.junit.Test;

public class Q913_CatAndMouse_TEST {
    @Test
    public void test1() {
        int[][] cast = {
                {2,5},
                {3},
                {0,4,5},
                {1,4,5},
                {2,3},
                {0,2,3}
        };

        Q913_CatAndMouse catAndMouse = new Q913_CatAndMouse();
        int result = catAndMouse.catMouseGame(cast);
        Assert.assertEquals(0,result);
    }

    @Test
    public void test2() {
        int[][] cast = {
                {3,4},
                {3,5},
                {3,6},
                {0,1,2},
                {0,5,6},
                {1,4},
                {2,4}
        };

        Q913_CatAndMouse catAndMouse = new Q913_CatAndMouse();
        int result = catAndMouse.catMouseGame(cast);
        Assert.assertEquals(0,result);
    }
}
