package linked;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(8);
        listNode.next.next.next.next = new ListNode(10);

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(7);
        listNode1.next.next.next.next = new ListNode(9);
        ListNode resultNode = solution.mergeTwoLists(listNode, listNode1);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }


    /**
     * 链表第K个节点
     *
     * @param head 链表
     * @param k    节点
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head 链表
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode temps = head;
        ListNode next;
        ListNode newNode = null;
        while (temps != null) {
            next = temps.next;
            temps.next = newNode;
            newNode = temps;
            temps = next;
        }
        head = newNode;
        return head;
    }

    /**
     * 合并两个排序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
