package io.github.packagewjx.algorithm.Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-3
 * 描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 **/
public class isPopOrder {
    public static void main(String[] args) {
        System.out.println(new isPopOrder().new Solution().IsPopOrder(new int[]{1}, new int[]{2}));
    }

    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> nums = new Stack<>();
            int pushedIndex = -1;
            for (int i = 0; i < popA.length; i++) {
                boolean thisNumBehind = false;
                for (int j = pushedIndex + 1; j < pushA.length; j++) {
                    if (pushA[j] == popA[i]) {
                        for (int k = pushedIndex + 1; k < j; k++) {
                            nums.push(pushA[k]);
                        }
                        pushedIndex = j;
                        thisNumBehind = true;
                        break;
                    }
                }
                if (!thisNumBehind) {
                    if (nums.empty() || nums.pop() != popA[i])
                        return false;
                }
            }
            return true;
        }
    }
}
