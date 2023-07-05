package a0704;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class kthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode pre = head, cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur!=null){
            pre = pre.next;
            cur = cur.next;
        }
        return pre.val;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

