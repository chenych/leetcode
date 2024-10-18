package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class ll_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
// 创建一个最小堆，根据节点的值进行比较
        PriorityQueue<ListNode> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // 将所有非空链表的头节点加入堆中
        for (ListNode h : lists) {
            if (h != null) {
                heap.offer(h);
            }
        }

        // 创建一个哑节点作为结果链表的头部
        ListNode s = new ListNode(-1, null);
        // t用于遍历结果链表
        ListNode t = s;

        // 当堆不为空时，循环继续
        while (!heap.isEmpty()) {
            // 从堆中取出当前最小的节点
            ListNode min = heap.poll();
            // 将取出的节点连接到结果链表上
            t.next = min;
            // 移动t指针到下一个位置
            t = t.next;
            // 如果取出的节点有后续节点，则将其加入堆中
            if (min.next != null) {
                heap.offer(min.next);
            }
        }

        // 返回结果链表的真实头部（跳过哑节点）
        return s.next;

    }
}
