package hot100;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 */
public class i_minWindow {
    public String minWindow(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        // needs是需要的字符和数量，window记录窗口中有效的字符和数量
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // valid 变量表示窗口中满足 need 条件的字符个数
        int valid = 0;
        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        for (char c : t) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == needs.size()) {
                // 在这里更新最小覆盖子串(更新最终结果)
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移要出窗口的字符
                char d = s[left];
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (needs.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    // window窗口内的数据无法满足，不再有效
                    // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                    if (window.get(d) < Integer.valueOf(needs.get(d))) {
                        valid--;
                    }
                }
            }
        }

        // 返回最小覆盖子串(使用三目运算使代码简洁)
        return len == Integer.MAX_VALUE ? "" : source.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        new i_minWindow().minWindow(s, t);
    }
}
