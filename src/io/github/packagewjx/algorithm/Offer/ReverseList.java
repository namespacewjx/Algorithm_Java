package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：输入一个链表，反转链表后，输出链表的所有元素。
 **/
public class ReverseList {
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode pre = null;
            ListNode cur = head;
            ListNode next = head.next;
            while (next != null) {
                cur.next = pre;
                pre = cur;
                cur = next;
                next = next.next;
            }
            cur.next = pre;
            return cur;
        }
    }
}
