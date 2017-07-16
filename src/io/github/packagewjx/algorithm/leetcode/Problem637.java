package io.github.packagewjx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 吴俊贤 on 2017/7/15.
 * Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/#/description
 */
public class Problem637 {
	public static void main(String[] args) {


	}

	//广度遍历办法,12ms
	public class Solution {
		public List<Double> averageOfLevels(TreeNode root) {
			List<Double> result = new ArrayList<>();

			if (root == null) {
				result.add(0.0);
				return result;
			}

			int nextLevelNodeCount = 0;
			int currentLevelNodeCount = 1;
			int currentCountedNodes = 0;
			double currentLevelSum = 0.0;
			LinkedList<TreeNode> nodes = new LinkedList<>();
			nodes.offer(root);

			while (nodes.size() != 0) {
				TreeNode node = nodes.poll();
				currentLevelSum += node.val;

				if (node.left != null) {
					nextLevelNodeCount++;
					nodes.offer(node.left);
				}
				if (node.right != null) {
					nextLevelNodeCount++;
					nodes.offer(node.right);
				}

				currentCountedNodes++;
				if (currentCountedNodes == currentLevelNodeCount) {
					result.add(currentLevelSum / currentCountedNodes);

					currentLevelNodeCount = nextLevelNodeCount;
					currentLevelSum = 0.0;
					currentCountedNodes = 0;
					nextLevelNodeCount = 0;
				}
			}

			return result;
		}
	}

	//前序遍历办法.11ms
	public class Solution1 {
		public List<Double> averageOfLevels(TreeNode root) {
			List<Double> levelSum = new ArrayList<>();
			List<Integer> levelNodes = new ArrayList<>();

			traverse(root, 0, levelSum, levelNodes);

			for (int i = 0; i < levelSum.size(); i++) {
				levelSum.set(i, levelSum.get(i) / levelNodes.get(i));
			}
			return levelSum;
		}

		public void traverse(TreeNode root, int currentLevel, List<Double> levelSum, List<Integer> levelNodes) {
			if (root == null)
				return;

			if (levelSum.size() == currentLevel) {
				levelSum.add(0.0);
				levelNodes.add(0);
			}

			levelNodes.set(currentLevel, levelNodes.get(currentLevel) + 1);
			levelSum.set(currentLevel, levelSum.get(currentLevel) + root.val);

			traverse(root.left, currentLevel + 1, levelSum, levelNodes);
			traverse(root.right, currentLevel + 1, levelSum, levelNodes);
		}
	}

}
