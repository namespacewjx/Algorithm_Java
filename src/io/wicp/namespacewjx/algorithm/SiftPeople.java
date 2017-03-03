package io.wicp.namespacewjx.algorithm;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/12.
 */
public class SiftPeople {
	/**
	 *
	 * @param args
	 * 参数规定：
	 * arg[0]代表放着所有可能的选项的文件，一个选项一行
	 * arg[1]代表放着人名和选项的文件，一个人一行，格式：“人名\t选项一\t选项二”，其中\t代表制表符
	 */
	public static void main(String[] args) {

	}

	public static void generateRandomChoices(){
		String[] choices = new String[] {"秘书部", "Fresh Campus", "宣传部", "Recycle项目组", "红树林保育项目组",
				"绿色生活推广小组", "能源项目组", "野外项目组", "环境教育项目组"};
		int[] weight = new int[]{8, 10, 7, 15, 12, 10, 20, 20, 10};

		int[] distribute = new int[weight.length];
		distribute[0] = weight[0];
		for (int i = 1; i < distribute.length; i++){
			distribute[i] = distribute[i - 1] + weight[i];
		}



	}

	private void generateRandomObjectArray(Object[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int pick = (int) (Math.random() * (double) (array.length - i));
			swap(array, pick, array.length - i - 1);
		}
	}

	private void swap(Object[] array, int index1, int index2) {
		Object temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}


	private class Group {
		private String name;
		private int expectedNumber;
		private Set<Wish> wishes;

		public Group(String name, int expectedNumber) {
			this.name = name;
			this.expectedNumber = expectedNumber;
		}

		public String getName() {
			return name;
		}

		public int getExpectedNumber() {
			return expectedNumber;
		}

		public void addWish(Wish wish) {
			wishes.add(wish);
		}

		public void removeWish(Wish wish) {
			wishes.remove(wish);
		}

		public final Set<Wish> getWishes() {
			return wishes;
		}
	}

	private class Wish {
		private String name;
		private Group firstWish;
		private Group secondWish;

		public Wish(String name, Group firstWish, Group secondWish) {
			this.name = name;
			this.firstWish = firstWish;
			this.secondWish = secondWish;
		}

		public Wish() {
		}

		public String getName() {
			return name;
		}

		public Group getFirstWish() {
			return firstWish;
		}

		public Group getSecondWish() {
			return secondWish;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setFirstWish(Group firstWish) {
			this.firstWish = firstWish;
		}

		public void setSecondWish(Group secondWish) {
			this.secondWish = secondWish;
		}
	}
}
