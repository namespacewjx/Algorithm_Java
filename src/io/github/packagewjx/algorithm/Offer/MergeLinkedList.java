package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：
 **/
public class MergeLinkedList {
    public static void main(String[] args) {
        System.out.println(new MergeLinkedList().new Solution().Merge(ListNode.getList(new int[]{1, 2, 6}), ListNode.getList(new int[]{4, 5, 6})));
    }


    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null)
                return list2;
            else if (list2 == null)
                return list1;


            ListNode p = list1;
            ListNode q = list2;
            ListNode n;
            if (p.val < q.val) {
                n = p;
                p = p.next;
            } else {
                n = q;
                q = q.next;
            }
            ListNode head = n;

            while (p != null && q != null) {
                if (p.val < q.val) {
                    n.next = p;
                    p = p.next;
                } else {
                    n.next = q;
                    q = q.next;
                }
                n = n.next;
            }

            if (p == null)
                n.next = q;
            else
                n.next = p;

            return head;
        }
    }
}
