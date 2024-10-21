package hot100test01;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class l_minWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        String result = "";
        Integer resLength = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (tmap.containsKey(s.charAt(r))) {
                smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (l <= r && isOK(smap, tmap)) {
                if (r - l + 1 < resLength) {
                    resLength = r - l + 1;
                    result = s.substring(l, r + 1);
                }
                smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return result;
    }

    private boolean isOK(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for (Character c : tmap.keySet()) {
            if (tmap.get(c) > smap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new l_minWindow().minWindow(s, t);
    }
}
