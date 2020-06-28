package com.jds.dsalgo.algoandds.interviewbit;

public class RemoveDuplicateListNode {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(1);
		listNode.next.next = new ListNode(1);
		listNode.next.next.next = new ListNode(2);
		ListNode a = deleteDuplicates(listNode);
		System.out.println(a.val + "," + a.next.val + "," + a.next);
	}

	public static ListNode deleteDuplicates(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode lastnode = A;
		ListNode cur = A.next;
		while (cur != null) {
			if (lastnode.val == cur.val) {
				lastnode.next = cur.next;
				cur = lastnode.next;
			} else {
				lastnode = cur;
				cur = cur.next;
			}
		}
		return A;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
