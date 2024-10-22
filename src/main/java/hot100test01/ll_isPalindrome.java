package hot100test01;

import hot100.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class ll_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getVal());
            head = head.getNext();
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
