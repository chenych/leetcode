package a0704;

import java.util.ArrayList;
import java.util.List;

/**
 * 2231. 按奇偶性交换后的最大数字
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * <p>
 * 返回交换任意次之后 num 的 最大 可能值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 * <p>
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 */
public class largestInteger {
    public static int largestInteger(int num) {
        String s = String.valueOf(num);
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> b2 = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                a1.add(s.charAt(i) - '0');
            } else {
                b2.add(s.charAt(i) - '0');
            }
        }
        a1.sort((o1, o2) -> o2 - o1);
        b2.sort((o1, o2) -> o2 - o1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0, j = 0; i < a1.size() || j < b2.size(); i++, j++) {
            if (i < a1.size()) {
                sb.append(a1.get(i));
            }
            if (j < b2.size()) {
                sb.append(b2.get(j));
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
    }
}
