package hot100test01;

public class g_trap {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (height[left] < height[right]) {
                ans += maxLeft - height[left];
                left++;
            } else {
                ans += maxRight - height[right];
                right--;
            }
        }
        return ans;
    }
}
