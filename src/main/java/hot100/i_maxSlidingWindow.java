package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class i_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = -10000;
            for (int j = i; j < i + k; j++) {
                //找出j到k的最大元素,同时放到结果数组
                max = Math.max(max, nums[j]);
            }
            r[i] = max;
        }
        return r;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] r = new int[nums.length - k + 1];
        r[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            r[i - k + 1] = pq.peek()[0];
        }
        return r;
    }
}
