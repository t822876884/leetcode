package leetcode.listNode;

public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 新增
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode append(ListNode head, int value) {
        ListNode listNode = new ListNode(value);
        if (head == null) {
            return listNode;
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = listNode;
        return node;
    }

    /**
     * 新增(哨兵节点)
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode newAppend(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode newNode = new ListNode(value);

        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;
    }

    /**
     * 删除
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode delete(ListNode head, int value) {
        if (head == null) {
            return head;
        }

        if (head.val == value) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        return head;
    }

    /**
     * 删除（哨兵节点）
     *
     * @param head
     * @param value
     * @return
     */
    public static ListNode newDelete(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        newAppend(head, 2);
        newAppend(head, 3);
        newAppend(head, 4);
        newAppend(head, 5);
        newAppend(head, 6);
        System.out.printf("" + head);
        newDelete(head, 3);
    }
}
