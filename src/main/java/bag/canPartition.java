package bag;

/**
 * 416. 分割等和子集
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class canPartition {
    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int target = sum / 2;
//
//        int[][] dp = new int[nums.length][target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < target; j++) {
//                dp[i][j] = Math.max(dp[i][j],dp[i][j])
//            }
//        }
//    }
        return false;
    }
}
