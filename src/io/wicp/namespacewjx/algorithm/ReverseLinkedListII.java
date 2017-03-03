package io.wicp.namespacewjx.algorithm;

public class ReverseLinkedListII {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "" + val;
		}
		
		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode prev = head;
		for (int i = 1; i < 5; i++){
			ListNode n = new ListNode(i + 1);
			prev.next = n;
			prev = n;
		}
		prev.next = null;
		
		ReverseLinkedListII r = new ReverseLinkedListII();
		head = r.reverseBetween(head, 1, 6);
		System.out.println();
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		int index = 1;//指示thisnode的下标
		ListNode thisnode = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode listfront = null;
		
		if (m <= 1){
			listfront = null;
			prev = thisnode;
			thisnode = thisnode.next;
			if (thisnode == null)//thisnode为空了，就没有交换的意义了
				return head;
			index += 1;
		}else{
			for(index = 1; index < m - 1; index++){
				if (thisnode == null)//如果还没有到m的前一个，就已经是null值，就说明m比链表的大小要大
					return head;
				thisnode = thisnode.next;
			}
			listfront = thisnode;
			prev = thisnode.next;
			thisnode = thisnode.next.next;
			if (thisnode == null)//thisnode为空了，就没有交换的意义了
				return head;
			index += 2;
		}
		next = thisnode.next;
		
		
		while (index < n && next != null){
			thisnode.next = prev;
			prev = thisnode;
			thisnode = next;
			next = next.next;
			index++;
		}
		thisnode.next = prev;
		
		if (m <= 1){
			head.next = next;
			head = thisnode;
		}else{
			listfront.next.next = next;
			listfront.next = thisnode;			
		}
		
		return head;
	}
}
