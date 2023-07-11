package a0706;
/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * 通过次数968,572提交次数2,332,604
 */
public class a_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int m = nums1.length;
        int n = nums2.length;
        int left = -1, right = -1;
        int astart = 0;
        int bstart = 0;
        for (int i = 0; i <= l / 2; i++) {
            left = right;
            if (astart < m && (bstart >= n || nums1[astart] < nums2[bstart])) {
                right = nums1[astart++];
            } else {
                right = nums2[bstart++];
            }
        }
        if ((l & 1) == 0) {
            return (right + left) / 2.0;
        }
        return right;
    }
}
