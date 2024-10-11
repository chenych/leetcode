package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的
 * 异位词
 * 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class h_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String ss = s.substring(i, p.length() + i);
            if (equals(ss, p)) {
                result.add(i);
            }
        }
        return result;
    }

    public Boolean equals(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] == charArray2[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // 初始化一个数组来统计字符串 p 中每个字符的出现次数
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        // l 和 r 分别表示滑动窗口的左右边界
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // 更新当前窗口中字符的计数数组
            cnt[s.charAt(r) - 'a']--;
            // 从左侧收缩窗口，直到当前字符的计数在限定范围内
            while (cnt[s.charAt(r) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // 检查当前窗口大小是否等于字符串 p 的大小
            if (r - l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            sCount[s.charAt(i) - 'a'] = sCount[s.charAt(i) - 'a'] + 1;
            pCount[p.charAt(i) - 'a'] = pCount[p.charAt(i) - 'a'] + 1;

        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            sCount[s.charAt(i) - 'a'] = sCount[s.charAt(i) - 'a'] - 1;
            sCount[s.charAt(i + pLen) - 'a'] = sCount[s.charAt(i + pLen) - 'a'] + 1;

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "abab", p = "ab";
        new h_findAnagrams().findAnagrams2(s, p);
    }
}
