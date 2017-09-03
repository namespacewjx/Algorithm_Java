package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 **/

import java.util.Stack;

public class MinStack {


    public class Solution {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            if (minStack.empty())
                minStack.push(node);
            else
                minStack.push(node < minStack.peek() ? node : minStack.peek());
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
