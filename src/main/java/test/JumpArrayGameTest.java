package test;

import answer.JumpArrayGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-11 下午5:35
 */
public class JumpArrayGameTest {
    static int[][] casts = {
            {2,3,1,1,4},
            {2,3,1,1,4,3,2,1}
    };

    @Test
    public void jump() {
        JumpArrayGame game = new JumpArrayGame();

        Assert.assertEquals(2,game.jump(casts[0]));
        Assert.assertEquals(3,game.jump(casts[1]));

        int len = 25000;
        int[] longCast = new int[len+2];
        for (int i = 0; i < len; i ++) longCast[i] = len - i;
        longCast[len] = 1;
        longCast[len+1] = 0;

        long start = System.currentTimeMillis();
        int steps = game.jump(longCast);
        System.out.println("cast length "+ len + ", cost " + (System.currentTimeMillis()-start) + " ms, answer is " + steps);
    }
}