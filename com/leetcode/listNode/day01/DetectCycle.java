package leetcode.listNode.day01;

import leetcode.listNode.ListNode;

/**
 * 找到链表中环的入口节点
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * <p><p><p>^______________|
 * <p>
 * 分析可知，有快慢指针，当两个指针的值相等时，此时节点为环中的节点。
 * <p>
 * 快指针先步进到环中的节点处，慢指针从头开始步进，当两个节点值相等时，即为入口节点
 */
public class DetectCycle {

    public static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }

        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.newAppend(head, 2);
        ListNode node = getNodeInLoop(head);
        System.out.printf("" + node);
    }
}
