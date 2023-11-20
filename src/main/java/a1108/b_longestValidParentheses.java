package a1108;


import java.util.Stack;

/**
 * 32. 最长有效括号
 * 困难
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class b_longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int rs = 0;
        Stack<Integer> st = new Stack();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    rs = Math.max(rs, i - st.peek());
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new b_longestValidParentheses().longestValidParentheses(")()())"));
    }
}
