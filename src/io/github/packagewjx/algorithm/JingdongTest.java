package io.github.packagewjx.algorithm;

import java.util.Stack;

/**
 * Created by 吴俊贤 on 2017/4/7.
 */
public class JingdongTest {

	public static int findThief(String queue) {
		if (queue == null || queue.length() == 0)
			return 0;

		Stack<Integer> thieves = new Stack<>();//存着目前发现的贼，会在当前位置的前面
		int found = 0;
		int capability = 0;//警察的影响范围
		boolean updateCapability = false;
		for (int i = 0; i < queue.length(); i++) {
			char cur = queue.charAt(i);
			if (cur == 'X') {
				if (capability == 0)
					thieves.add(i);
				else
					found++;
			} else if (cur >= '1' && cur <= '9') {
				if (capability <= cur - '0'){
					capability = cur - '0';
				} else
					updateCapability = true;//这一个位置的capa应该更新，不过


				//遍历链表，查看前面是否有可以发现的
				while (!thieves.isEmpty()) {
					Integer thief = thieves.peek();
					if (i - thief <= capability) {
						found++;
						thieves.pop();
					} else {
						break;
					}
				}

				if (updateCapability){
					capability--;
					updateCapability = false;
				}
				continue;//为了不更新capability
			}
			if (capability > 0)
				capability--;
		}

		return found;
	}
}
