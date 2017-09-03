package io.github.packagewjx.algorithm.Offer;

/**
 * @author <a href="mailto:812730157@qq.com">吴俊贤</a>
 * 创建日期： 17-9-2
 * 描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class ReorderArray {
    public static void main(String[] args) {
        new ReorderArray().new Solution2().reOrderArray(new int[]{2, 4, 1, 5, 4, 6, 2, 3, 7, 5});
    }

    public class Solution {
        //利用两个数组的作弊法
        public void reOrderArray(int[] array) {
            int[] a = new int[array.length];
            int[] even = new int[array.length];
            int cur = 0;
            int evenCur = 0;
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 1)
                    a[cur++] = array[i];
                else
                    even[evenCur++] = array[i];
            }
            for (int i = evenCur - 1; i >= 0; i--) {
                a[cur + i] = even[i];
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = a[i];
            }
        }
    }

    public class Solution2 {
        //利用两个数组的作弊法
        public void reOrderArray(int[] array) {
            int[] even = new int[array.length];
            int evenCur = 0;
            int p = 0, q = 0;
            while (q < array.length) {
                if ((array[q] & 1) == 0)
                    even[evenCur++] = array[q];
                else
                    array[p++] = array[q];
                q++;
            }
            q = 0;
            while (q < evenCur) {
                array[p++] = even[q++];
            }
        }
    }

}
