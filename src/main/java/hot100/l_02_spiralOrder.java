package hot100;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 中等
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class l_02_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bom = m - 1;
        List<Integer> list = new ArrayList<>();
        while (left <= right && top <= bom) {
            //从左到右
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            //从上到下
            for (int i = top; i <= bom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            //从右到左
            if (top <= bom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bom][i]);
                }
            }
            bom--;
            //从下到上
            if (left <= right) {
                for (int i = bom; i >= top; i--) {
                    list.add(matrix[top][left]);
                }
            }
            left++;
        }
        return list;
    }
}
