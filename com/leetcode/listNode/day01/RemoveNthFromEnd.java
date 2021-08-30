package leetcode.listNode.day01;

import leetcode.listNode.ListNode;

/**
 * 删除倒数第K个节点 1<=k<=n
 * <p>
 * 例如删除下列列表倒数第2个节点
 * (a) 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * (b) 1 -> 2 -> 3 -> 4 -> 6
 * <p>
 * 分析，定义两个指针，快的指针先步进 k-1 步
 * 然后两个指针同时向前步进，当快指针到达尾部时，慢指针正好是需要删除的节点
 */
public class RemoveNthFromEnd {

    /**
     * @param head  需要操作的链表
     * @param n 需要删除的链表值
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个哨兵节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast!= null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.newAppend(head, 2);
        ListNode.newAppend(head, 3);
        ListNode.newAppend(head, 4);
        ListNode.newAppend(head, 5);
        ListNode.newAppend(head, 6);
        removeNthFromEnd(head, 2);
        System.out.printf("---------");
    }}
