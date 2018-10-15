package answer;

/**
 * 描述:
 *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *  请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n))
 *  你可以假设 nums1 和 nums2 不同时为空。
 *
 * @author 巴荞 siling.zsl@alibaba-inc.com
 * @create 2018-10-10 下午3:25
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return medianOfArray(nums2);
        }else if (nums2 == null) {
            return medianOfArray(nums1);
        }else {
            int count = nums1.length + nums2.length;
            int medianPos = count / 2;

            // 合并数组，长度到medianPos
            int[] mergeNums = mergeArray(nums1,nums2,medianPos+1);
            if (count % 2 > 0) {
                return mergeNums[medianPos];
            }else{
                return (mergeNums[medianPos] + mergeNums[medianPos-1]) / 2.0;
            }
        }
    }

    private double medianOfArray(int[] nums) {
        if (nums.length % 2 > 0) {
            int medianPos = nums.length / 2;
            return nums[medianPos];
        }else{
            int medianPos = nums.length / 2 - 1;
            return (nums[medianPos] + nums[medianPos+1]) / 2.0;
        }
    }

    private int[] mergeArray(int[] nums1, int[] nums2, int maxLength) {
        int[] merge = new int[maxLength];
        int pos1 = 0, pos2 = 0;
        for (int i = 0; i < maxLength; i ++) {
            if (pos1 == nums1.length) {
                merge[i] = nums2[pos2++];
            }else if (pos2 == nums2.length) {
                merge[i] = nums1[pos1++];
            }else {
                if (nums1[pos1] < nums2[pos2]) {
                    merge[i] = nums1[pos1++];
                } else {
                    merge[i] = nums2[pos2++];
                }
            }
        }

        return merge;
    }
}
