package hot100test01;

import java.util.HashMap;
import java.util.Map;

public class ll_copyRandomList {
    Map<Node, Node> mm = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!mm.containsKey(head)) {
            Node node = new Node(head.val);
            node.next = copyRandomList(head.random);
            node.random = copyRandomList(head.random);
            mm.put(node, node);
        }
        return mm.get(head);
    }
}
