package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组
 * 是数组中的一个连续部分。
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class k_01_maxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }
}
