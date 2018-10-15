package test;

import answer.FindMedianSortedArrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-10 下午3:30
 */
public class FindMedianSortedArraysTest {
    final static double delta = 0.00001;

    FindMedianSortedArrays func = new FindMedianSortedArrays();

    @Test
    public void one_is_null() {
        int[] nums1 = null;
        int[] nums2 = {1,2,3};
        int[] nums3 = {1,2};

        Assert.assertEquals(2,func.findMedianSortedArrays(nums1,nums2),delta);
        Assert.assertEquals(1.5,func.findMedianSortedArrays(nums1,nums3),delta);
    }

    @Test
    public void all_not_null() {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2};
        int[] nums3 = {4,5};

        Assert.assertEquals(2,func.findMedianSortedArrays(nums1,nums2),delta);
        Assert.assertEquals(3,func.findMedianSortedArrays(nums1,nums3),delta);
        Assert.assertEquals(3,func.findMedianSortedArrays(nums2,nums3),delta);
    }
}
