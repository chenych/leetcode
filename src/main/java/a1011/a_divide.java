package a1011;

/**
 * 29. 两数相除
 * 中等
 * 1.2K
 * 相关企业
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * <p>
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。
 * 本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 * <p>
 * 提示：
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class a_divide {
    public int divide(int dividend, int divisor) {
        int MAX = 2147483647;
        int MIN = -2147483648;
        //首先进行预处理
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend < MAX * -1 ? MAX : dividend * -1;
        //开始向减
        long res = 0, a = dividend, b = divisor, flag = -1;
        if (a >= 0 && b > 0 || a < 0 && b < 0) flag = 1;
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            a -= b;
            res++;
        }
        return (int) (res * flag);
    }


    public static void main(String[] args) {
        System.out.println(new a_divide().divide(-2147483648, -1));
    }
}
