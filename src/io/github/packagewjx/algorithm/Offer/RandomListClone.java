package io.github.packagewjx.algorithm.Offer;

import java.util.HashMap;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-3
 * 描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 **/
public class RandomListClone {
    public static void main(String[] args) {
        RandomListNode node = RandomListNode.construct(new Integer[]{1, 2, 3, 4, 5, 3, 5, null, 2, null});
        new RandomListClone().new Solution().Clone(node);
    }


    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null)
                return null;

            RandomListNode head = pHead;
            while (pHead != null) {
                if ((pHead.next != null && pHead.next.label != pHead.label) || pHead.next == null) {
                    //如果这个节点的下一个节点不是复制节点，在这个节点的尾部，复制一个新的节点
                    RandomListNode cNode = new RandomListNode(pHead.label);
                    cNode.next = pHead.next;
                    pHead.next = cNode;
                    //查看这个节点的随机下一个节点的下一个节点是不是复制节点
                    if (pHead.random != null) {
                        if (pHead.random.next == null || pHead.random.next.label != pHead.random.label) {
                            //如果不是，则在这个节点新建一个复制节点，并将cNode链接到新节点。
                            RandomListNode rNode = new RandomListNode(pHead.random.label);
                            rNode.next = pHead.random.next;
                            pHead.random.next = rNode;
                            cNode.random = rNode;
                        } else {
                            //如果是复制节点，则直接连接
                            cNode.random = pHead.random.next;
                        }
                    }
                } else {
                    if (pHead.random != null) {
                        if (pHead.random.next == null || pHead.random.next.label != pHead.random.label) {
                            //如果不是，则在这个节点新建一个复制节点，并将cNode链接到新节点。
                            RandomListNode rNode = new RandomListNode(pHead.random.label);
                            rNode.next = pHead.random.next;
                            pHead.random.next = rNode;
                            pHead.next.random = rNode;
                        } else {
                            //如果是复制节点，则直接连接
                            pHead.next.random = pHead.random.next;
                        }
                    }
                }
                //到这里，pHead的下一个节点应该是复制节点
                pHead = pHead.next.next;
            }

            //断开新链表和旧链表
            RandomListNode newHead = head.next;
            RandomListNode oldCur = head;
            RandomListNode newCur = newHead;
            while (newCur.next != null) {
                oldCur.next = newCur.next;
                oldCur = oldCur.next;
                newCur.next = oldCur.next;
                newCur = newCur.next;
            }
            oldCur.next = null;
            return newHead;
        }
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public static RandomListNode construct(Integer[] nums) {
        if (nums == null || (nums.length & 1) != 0 || nums.length == 0)
            return null;

        HashMap<Integer, RandomListNode> nodes = new HashMap<>();
        RandomListNode head = new RandomListNode(nums[0]);
        nodes.put(nums[0], head);
        RandomListNode last = head;
        for (int i = 1; i < nums.length / 2; i++) {
            RandomListNode node = new RandomListNode(nums[i]);
            nodes.put(node.label, node);
            last.next = node;
            last = node;
        }
        last = head;
        for (int i = nums.length / 2; i < nums.length; i++) {
            if (nums[i] != null)
                last.random = nodes.get(nums[i]);
            last = last.next;
        }
        return head;
    }
}