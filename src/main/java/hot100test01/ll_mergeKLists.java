package hot100test01;

public class ll_mergeKLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null && b == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, apr = a, bpr = b;
        while (apr != null && bpr != null) {
            if (apr.val < bpr.val) {
                tail.next = apr;
                apr = apr.next;
            } else {
                tail.next = bpr;
                bpr = bpr.next;
            }
            tail = tail.next;
        }
        tail.next = apr == null ? bpr : apr;
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

}
