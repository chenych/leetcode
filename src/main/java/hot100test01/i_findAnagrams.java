package hot100test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
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
public class i_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        //外层循环扩展右边界，内层循环扩展左边界
        for (int l = 0, r = 0; r < s.length(); r++) {
            //当前考虑的元素
            cnt[s.charAt(r) - 'a']--;
            while (cnt[s.charAt(r) - 'a'] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (r - l + 1 == p.length()) {
                result.add(l);
            }
            //区间[left,right]符合题意，统计相关信息
        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int[] cnt = new int[26];
        List list = new ArrayList();
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a']--;
            while (cnt[s.charAt(r)] < 0) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (r - l + 1 == p.length()) {
                list.add(l);
            }
        }
        return list;
    }
}

