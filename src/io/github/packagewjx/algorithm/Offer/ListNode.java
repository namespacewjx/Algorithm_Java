package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：
 **/
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode getList(int[] list) {
        if (list == null || list.length == 0)
            return null;

        ListNode tail = new ListNode(list[0]);
        ListNode head = tail;
        for (int i = 1; i < list.length; i++) {
            ListNode newNode = new ListNode(list[i]);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
