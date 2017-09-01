package io.github.packagewjx.algorithm.Offer;

/**
 * @author 吴俊贤
 * Email: wu812730157@gmail.com
 * Date: 17-9-1
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class SearchNumIn2DArray {
    public class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null)
                return false;
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i].length > 0 && array[i][0] <= target) {
                    for (int j = 0; j < array[0].length; j++) {
                        if (array[i][j] > target) {
                            break;
                        }
                        else if (array[i][j] == target)
                            return true;
                    }
                }
            }
            return false;
        }
    }

}
