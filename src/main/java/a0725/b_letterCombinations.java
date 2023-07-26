package a0725;

import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class b_letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(result, phoneMap, digits, 0, new StringBuffer());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int i, StringBuffer combination) {
        if (i == digits.length()) {
            result.add(combination.toString());
        } else {
            char c = digits.charAt(i);
            String s = phoneMap.get(c);
            int count = s.length();
            for (int j = 0; j <count ; j++) {
                combination.append(s.charAt(j));
                backtrack(result,phoneMap,digits,i+1,combination);
                combination.deleteCharAt(i);
            }
        }
    }

    public static void main(String[] args) {
        new b_letterCombinations().letterCombinations("23");
    }
}
