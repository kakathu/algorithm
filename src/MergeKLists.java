import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists) {
            if(node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode tail = dummy;
        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = curr;
            if(curr.next != null) {
                pq.offer(curr.next);
            }
            tail.next = null;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
