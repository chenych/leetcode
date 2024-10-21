package hot100test01;

import java.util.*;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class arr_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.size() == 0) {
                ans.add(intervals[i]);
            } else {
                int lastto = ans.get(ans.size() - 1)[1];
                int from = intervals[i][0], to = intervals[i][1];
                if (from > lastto) {
                    ans.get(ans.size() - 1)[1] = Math.max(lastto, to);
                } else {
                    ans.add(intervals[i]);
                }

            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
