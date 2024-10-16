package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class ll_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode.val);
            listNode = head.next;
        }

        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
