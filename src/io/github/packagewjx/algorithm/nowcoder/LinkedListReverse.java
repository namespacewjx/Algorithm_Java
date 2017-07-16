package io.github.packagewjx.algorithm.nowcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 吴俊贤 on 2017/4/26.
 * https://www.nowcoder.com/pat/6/problem/4051
 * 这道题花了挺长时间！必须要好好看看，这里有给链表的各个节点的地址，然后建立起链表的代码。还有翻转一个链表的代码
 * TODO 有错啊，不知道在哪里
 */
public class LinkedListReverse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int headAdd = in.nextInt();
		int total = in.nextInt();
		int k = in.nextInt();

		/**
		 * 开始建立链表
		 */
		HashMap<Integer, Node> nodes = new HashMap<>(total);
		Node head = new Node();
		head.address = headAdd;
		nodes.put(headAdd, head);

		for (int i = 0; i < total; i++) {
			int address = in.nextInt();
			Node node;
			//首先查看哈希表中是否有这个节点，若有，则取出并写值，若无，则新建一个节点，并put到map中，因为暂时没有其他node的next是这个node
			if ((node = nodes.remove(address)) == null) {
				node = new Node();
				node.address = address;
				nodes.put(address, node);
			}
			node.val = in.nextInt();

			//查看hash表中是否有下一个节点，没有，则创建一个新的
			int nextAdd = in.nextInt();
			Node next;
			if ((next = nodes.remove(nextAdd)) == null && nextAdd != -1) {
				next = new Node();
				next.address = nextAdd;
				nodes.put(nextAdd, next);//由于这个节点没有值，因此放回去，等到后面读取值
			}
			node.setNext(next);
		}

		//注意，有无效的节点，因此必须更新total，否则会出错
		int count = 0;
		Node cur = head;
		while (cur != null) {
			count++;
			cur = head.getNext();
		}
		total = count;

		/**
		 * 翻转链表
		 */
		head = reverseList(head, k, total);

		/**
		 * 打印链表
		 */
		cur = head;
		while (cur.getNext() != null) {
			System.out.printf("%05d %d %05d\n", cur.address, cur.val, cur.getNext().address);
			cur = cur.getNext();
		}
		System.out.printf("%05d %d -1", cur.address, cur.val);
	}

	public static Node reverseList(Node head, int k, int size) {
		Node lastTail = null;//上一段被翻转的尾节点，初始是null
		Node newHead = null;//新的头，用于返回值
		Node oldHead = head;//保存着旧链表的头，也就是新链表的尾，这个节点需要指向第k+1个元素
		Node p = head;
		Node q = head.getNext();
		for (int i = 0; i < size / k; i++) {
			Node temp;
			for (int j = 0; j < k - 1; j++) {
				//循环执行k次
				temp = q.getNext();
				q.setNext(p);
				p = q;
				q = temp;
			}
			if (lastTail == null)
				newHead = p;
			else
				lastTail.setNext(p);
			oldHead.setNext(q);
			lastTail = oldHead;
			oldHead = q;
			if (q == null)//若全部翻转完成，q会变成空指针，直接退出即可
				break;
			p = q;
			q = q.getNext();
		}
		return newHead;

	}
}

class Node {
	int address;
	int val;
	private int nextAdd;
	private Node next;

	void setNext(Node next) {
		if (next == null)
			nextAdd = -1;
		else
			nextAdd = next.address;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}
}