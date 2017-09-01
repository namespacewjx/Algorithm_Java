package io.github.packagewjx.algorithm.Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 * 输入一个链表，从尾到头打印链表每个节点的值。
 **/
public class GetLinkedListFromEndToStart {
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> nums = new Stack<>();
            while (listNode != null) {
                nums.add(listNode.val);
                listNode = listNode.next;
            }
            ArrayList<Integer> result = new ArrayList<>(nums.size() + 1);
            while (!nums.isEmpty())
                result.add(nums.pop());
            return result;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}