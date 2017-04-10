package io.github.packagewjx.algorithm;

import java.util.*;

/**
 * Created by 吴俊贤 on 2017/4/3.
 */
public class LinkedList<T extends Object> implements Queue<T>, List<T> {

	public static class Tester {
		public static void main(String[] args) {
			LinkedList<Integer> list = new LinkedList<>();

			System.out.println("空链表输出数据");
			list.printAll();
			System.out.println(list.size());

			System.out.println("空链表删除并输出");
			list.remove();
			list.printAll();
			list.remove(new Integer(2));
			list.printAll();
			list.remove(0);

			System.out.println("空链表获取数据");
			System.out.println(list.get(0));
			System.out.println(list.get(1));
			System.out.println(list.peek());
			System.out.println(list.poll());

			System.out.println("空链表");




		}


	}


	private class Node {
		T val;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void printAll() {
		System.out.println("size: " + size);
		int index = 0;
		for (Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d: %s", index++, cur.val);
		}
	}


	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		for (T t : c) {
			this.add(t);
		}
		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of Bound: " + index);
		}

		Node cur = head;
		for (int i = 0; i < index; i++) {
			cur = head.next;
		}

		return cur.val;
	}

	@Override
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of Bound: " + index);
		}

		Node cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}

		T ret = cur.val;
		cur.val = element;
		return ret;
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of Bound: " + index);
		}

		size++;//先给size加一保证不出错

		//创建新的结点
		Node newNode = new Node();
		newNode.val = element;

		if (head == null) {
			head = tail = newNode;
			return;
		}

		//index为0，则加入到newNode成为新的头结点
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}


		//如果index是size，则成为新的尾元素
		if (index == size) {
			tail.next = newNode;
			tail = newNode;
			return;
		}

		//都不是，则是插入中间的节点
		Node cur = head;
		for (int i = 0; i < index - 1; i++) {
			cur = head.next;
		}//到达前一个节点
		newNode.next = cur.next;
		cur.next = newNode;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of Bound: " + index);
		}

		size--;//先减保证正确

		//若是删除头结点
		if (index == 0) {
			T ret = head.val;
			head = head.next;
			return ret;
		}

		//删除后面的结点
		Node cur = head;
		for (int i = 0; i < index - 1; i++) {
			cur = head.next;
		}//到达前一个节点

		//若是删除尾节点，则需要重新设置尾节点
		if (index == size - 1)
			tail = cur;

		T ret = cur.next.val;
		cur.next = cur.next.next;

		return ret;
	}

	@Override
	public int indexOf(Object o) {
		if (head == null || o == null) {
			return -1;
		}
		int index = 0;
		for (Node cur = head; cur != null; cur = cur.next) {
			if (cur.val.equals(o)) {
				return index;
			}
			index++;
		}
		return index == size ? -1 : index;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o == null || head == null) {
			return -1;
		}
		int ret = 0;
		Node cur = head;
		for (int i = 0; i < size; i++) {
			if (cur.val.equals(o)) {
				ret = i;
			}
			cur = cur.next;
		}
		return ret;
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return null;
	}

	@Override
	public boolean add(T t) {
		size++;

		Node newNode = new Node();
		newNode.val = t;
		if (head == null) {
			head = tail = newNode;
			return true;
		}

		tail.next = newNode;
		tail = newNode;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (head == null) {
			return false;
		}

		size--;


		//若要删除的对象是头结点的对象
		if (head.val.equals(o)) {
			if (head == tail) {
				head = tail = null;
				return true;
			}

			head = head.next;
			return true;
		}

		Node cur = head;
		//若是中间节点，不是尾节点
		for (; cur.next != tail; cur = cur.next) {
			if (cur.next.val.equals(o)) {
				cur.next = cur.next.next;
				return true;
			}
		}

		//若是尾节点
		if (tail.val.equals(o)) {
			cur.next = null;
			tail = cur;
			return true;
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		//是把head和tail两个直接remove掉就行了吗？
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean offer(T t) {
		return add(t);
	}

	@Override
	public T remove() {
		return poll();
	}

	@Override
	public T poll() {
		if (head == null)
			return null;
		size--;
		T ret = head.val;
		head = head.next;
		if (head == null)
			tail = null;
		return ret;
	}

	@Override
	public T element() {
		return peek();
	}

	@Override
	public T peek() {
		return head != null ? head.val : null;
	}
}
