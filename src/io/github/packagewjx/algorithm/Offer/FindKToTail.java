package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：
 **/
public class FindKToTail {
    public class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            ListNode first = head;
            for (int i = 0; i < k; i++) {
                if (first == null)
                    return null;
                first = first.next;
            }
            ListNode result = head;
            while (first != null) {
                first = first.next;
                result = result.next;
            }
            return result;
        }
    }
}
